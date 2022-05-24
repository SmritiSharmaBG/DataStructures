package com.dataStructure.stack;

import java.io.*;
import java.util.*;

public class FunGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        String[] arr_arr = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i_arr = 0; i_arr < arr_arr.length; i_arr++) {
            arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
        }

        funGame(arr);
        wr.close();
        br.close();
    }

    static void funGame(int[] arr) {
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        fillStacks(a, b, arr);
        while (!a.isEmpty() && !b.isEmpty()) {
            int intA = a.peek();
            int intB = b.peek();
            if (intA > intB) {
                System.out.print("1 ");
                b.pop();
            } else if (intB > intA) {
                System.out.print("2 ");
                a.pop();
            } else {
                System.out.print("0 ");
                a.pop();
                b.pop();
            }
        }
    }

    private static void fillStacks(Stack<Integer> a, Stack<Integer> b, int[] arr) {
        for (int i : arr) {
            b.add(i);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            a.add(arr[i]);
        }
    }
}
