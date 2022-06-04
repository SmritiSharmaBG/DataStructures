package com.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Queue {
    private int capacity, front, rear;
    private int[] arr;

    Queue(int capacity) {
        this.capacity = capacity;
        front = rear = -1;
        arr = new int[capacity];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of elements");
        Queue queue = new Queue(Integer.parseInt(br.readLine()));
        // define custom operations here
        queue.enqueue(10);
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    private boolean isEmpty() {
        return front == -1;
    }

    private int dequeue() {
        int temp = -1;
        if (front == -1) {
            System.out.println("Queue Underflow. Element not deleted");
            return -1;
        } else if (rear == front) {
            temp = arr[front];
            rear = front = -1;
            return temp;
        } else {
            temp = arr[front];
            front++;
            return temp;
        }
    }

    private void enqueue(int x) {
        if (rear == capacity - 1) {
            System.out.println("Queue Overflow. Element not inserted");
            return;
        }
        if (rear == -1) { //queue was empty
            front = rear = 0;
        } else {
            rear++;
        }
        arr[rear] = x;
    }

}