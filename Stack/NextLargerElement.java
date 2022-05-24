package com.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * This is a very common question of stack. An array is given. For each element of the array, the aim is to find the next largest element to its right.
 */
public class NextLargerElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] str = line.trim().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        arr = findNextLargestElement(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }

    private static int[] findNextLargestElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            if (stack.isEmpty()) {
                list.add(-1);
                stack.push(num);
            } else {
                if (num < stack.peek()) {
                    list.add(stack.peek());
                    stack.add(num);
                } else {
                    while (!stack.isEmpty() && num > stack.peek()) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        list.add(-1);
                    } else if (num < stack.peek()) {
                        list.add(stack.peek());
                    }
                    stack.push(num);
                }
            }
        }
        int pos = arr.length - 1;
        for (int i : list) {
            arr[pos] = i;
            pos--;
        }
    }
}
