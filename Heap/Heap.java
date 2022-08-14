package com.dataStructure.heap;

import java.util.Scanner;

public class Heap {
    private static int size = 10;
    private static int[] heap;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        heap = new int[size];
        n = 0;
        while (true) {
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Print Array");
            int in = sc.nextInt();
            switch (in) {
                case 1: {
                    // Insertion
                    if (n >= size) {
                        System.out.println("No more insertion possible. Ending ...");
                        break;
                    }
                    System.out.println("Enter the element to be inserted");
                    int num = sc.nextInt();
                    insertInHeap(num, ++n);
                    System.out.println("Element inserted.");
                    break;
                }
                case 2: {
                    // Deletion
                    if (n <= 0) {
                        System.out.println("No more deletion possible. Ending ...");
                        break;
                    }
                    deleteFromHeap();
                    System.out.println("Element deleted.");
                    break;
                }
                case 3: {
                    printArray();
                }
            }
        }
    }

    private static void deleteFromHeap() {
        int lastElement = heap[n--];
        heap[1] = lastElement;
        heapifyDel(1);
    }

    private static void heapifyDel(int i) {
        int left = 2 * i;
        int right = (2 * i) + 1;
        int largestIndex = i;
        if (left <= n && heap[left] > heap[largestIndex]) largestIndex = left;
        if (right <= n && heap[right] > heap[largestIndex]) largestIndex = right;
        if (i != largestIndex) {
            int temp = heap[i];
            heap[i] = heap[largestIndex];
            heap[largestIndex] = temp;
            heapifyDel(largestIndex);
        }
    }

    private static void printArray() {
        System.out.println("------------------------------------");
        for (int i = 1; i <= n; i++) {
            int it = heap[i];
            System.out.print(it + ", ");
        }
        System.out.println("\n------------------------------------");
    }

    private static void insertInHeap(int in, int n) {
        heap[n] = in;
        heapifyIn(n);
    }

    private static void heapifyIn(int i) {
        if (i == 1) return;
        int parent = i / 2;
        if (heap[i] > heap[parent]) {
            int temp = heap[i];
            heap[i] = heap[parent];
            heap[parent] = temp;
            heapifyIn(parent);
        }
    }
}
