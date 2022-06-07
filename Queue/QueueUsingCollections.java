package com.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueUsingCollections {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        try {
            queue.add(10); // 10
            System.out.println(queue.remove()); // should return 10
            System.out.println(queue.isEmpty()); // should return true
            queue.add(10); // 10
            queue.add(20); // 10 -> 20
            queue.add(30); // 10 -> 20 -> 30
            queue.add(40); // 10 -> 20 -> 30 -> 40
            System.out.println(queue.remove()); // should return 10; 20 -> 30 -> 40
            queue.add(40); // 20 -> 30 -> 40 -> 40
            System.out.println(queue.remove()); // should return 20; 30 -> 40 -> 40
            System.out.println(queue.remove()); // should return 30; 40 -> 40
            System.out.println(queue.remove()); // should return 40; 40
            System.out.println(queue.remove()); // should return 40;
            System.out.println(queue.remove()); // UnderFlow
        } catch (NoSuchElementException n) {
            System.out.println("UnderFlow occurred");
        }
    }
}
