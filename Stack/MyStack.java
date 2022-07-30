package com.dataStructure.stack;

public class MyStack {
    int size;
    int [] arr;
    int top;
    MyStack(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    void push(int elem) {
        System.out.println("PUSHING -- " + elem);
        top ++;
        if(top >= size) {
            System.out.println("STACK OVERFLOW");
            return;
        }
        arr[top] = elem;
    }

    int pop() {
        System.out.println("POPPING");
        if(isEmpty()) {
            System.out.println("STACK UNDERFLOW");
            return -1;
        }
        int elem = arr[top];
        top --;
        return elem;
    }

    int peek() {
        if(isEmpty()) {
            System.out.println("STACK EMPTY");
            return -1;
        }
        return arr[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top >= size - 1;
    }

    public static void main(String[] args) {
        MyStack s = new MyStack(7);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.isFull());
        s.push(1);
        System.out.println(s.pop());
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.pop());
        s.push(6);
        System.out.println(s.peek());
        s.push(7);
        s.push(8);
        s.push(9);
        s.push(10);
        s.push(11);
    }
}
