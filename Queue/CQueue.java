package com.dataStructure.queue;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CQueue {
    private int front, rear, capacity;
    private int[] arr;

    CQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = rear = -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of elements"); // give 3
        CQueue cQueue = new CQueue(Integer.parseInt(br.readLine()));
        // define custom operations here
        cQueue.enqueue(10); // 10
        System.out.println(cQueue.dequeue()); // should return 10
        System.out.println(cQueue.isEmpty()); // should return true
        cQueue.enqueue(10); // 10
        cQueue.enqueue(20); // 10 -> 20
        cQueue.enqueue(30); // 10 -> 20 -> 30
        cQueue.enqueue(40); // queue overflow !
        System.out.println(cQueue.dequeue()); // 20 -> 30
        cQueue.enqueue(40); // 20 -> 30 -> 40
        System.out.println(cQueue.isFull()); // should return true
        System.out.println(cQueue.dequeue()); // should return 20;  30 -> 40
        System.out.println(cQueue.dequeue()); // should return 30;  40
        System.out.println(cQueue.dequeue()); // should return 40;
        System.out.println(cQueue.dequeue()); // queue underflow !
        System.out.println(cQueue.isFull()); // should return false
    }

    private boolean isFull() {
        return ((front == 0 && rear == capacity - 1) || front == rear + 1);
    }

    private boolean isEmpty() {
        return front == -1;
    }

    private int dequeue() {
        int temp = -1;
        if (front == -1) {
            System.out.println("Queue Underflow. Element not deleted");
            return temp;
        }
        temp = arr[front];
        if (rear == front) {
            rear = front = -1;
        } else if (front == capacity - 1) {
            front = 0;
        } else {
            front++;
        }
        return temp;
    }

    private void enqueue(int x) {
        if ((front == 0 && rear == capacity - 1) || front == rear + 1) {
            System.out.println("Queue Overflow. Element not inserted");
            return;
        }
        if (rear == -1) {
            rear = front = 0;
        } else if (rear == capacity - 1) {
            rear = 0;
        } else {
            rear++;
        }
        arr[rear] = x;
    }
}
