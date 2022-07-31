package com.dataStructure.stack;

class Node {
    Node pre;
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        pre = next = null;
    }
}

class MyStack2 {
    int size;
    Node top;
    Node middle;

    MyStack2() {
        this.size = 0;
        top = middle = null;
    }

    void push(int data) {
        Node node = new Node(data);
        size++;
        if (top == null) {
            top = node;
            middle = top;
            return;
        }
        top.next = node;
        node.pre = top;
        top = top.next;
        if (size % 2 != 0) { // even-th entry; then don't increment mid
            middle = middle.next;
        }
    }

    int pop() {
        int elem = top.data;
        if (size % 2 != 0) {
            middle = middle.pre;
        }
        top = top.pre;
        size--;
        return elem;
    }

    int findMiddle() {
        return middle.data;
    }

    int deleteMiddle() {
        int elem = middle.data;
        middle = middle.pre;
        top = top.pre;
        size--;
        return elem;
    }
}

public class MidOfStack {
    public static void main(String[] args) {
        MyStack2 ms = new MyStack2();
        ms.push(11);
        ms.push(22);
        ms.push(33);
        ms.push(44);
        ms.push(55);
        ms.push(66);
        ms.push(77);
        ms.push(88);
        ms.push(99);

        System.out.println("Old Middle Element : "
                + ms.findMiddle());
        System.out.println("Popped : " + ms.pop());
        System.out.println("Popped : " + ms.pop());
        System.out.println("Middle Element : "
                + ms.findMiddle());
        System.out.println("Middle Element delete : " + ms.deleteMiddle());
        System.out.println("New Middle Element : "
                + ms.findMiddle());

    }
}