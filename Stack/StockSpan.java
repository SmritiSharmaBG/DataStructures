package com.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] str = line.trim().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        arr = solveStockSpan(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }

    private static int[] solveStockSpan(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            while (!stack.isEmpty() && num >= arr[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                result.add(i+1);
            }
            else if(num<arr[stack.peek()])
            {
                result.add(i-stack.peek());
            }
            stack.push(i);
        }
        int[] a=new int[result.size()];
        int pos=0;
        for(int i:result)
        {
            a[pos]=i;
            pos++;
        }
        return a;
    }
}
