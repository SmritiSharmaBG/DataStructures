package com.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the infix expression");
        String line = br.readLine();
        String ans = findPostfix(line);
        System.out.print("the equivalent postfix solution is = " + ans);
    }

    private static String findPostfix(String str) {
        String ans = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    ans += stack.pop();
                if (stack.peek() == '(')
                    stack.pop();
            } else if (c == '+' || c == '-') {
                while (!stack.isEmpty() && (stack.peek() == '^' || stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '+' || stack.peek() == '-'))
                    ans += stack.pop();
                stack.push(c);
            } else if (c == '*' || c == '/') {
                while (!stack.isEmpty() && (stack.peek() == '^' || stack.peek() == '/' || stack.peek() == '*'))
                    ans += stack.pop();
                stack.push(c);
            } else if (c == '^') {
                if (!stack.isEmpty() && stack.peek() == '^')
                    ans += c;
                else
                    stack.push(c);
            } else
                ans += c;
        }
        while (!stack.isEmpty())
            ans += stack.pop();
        return ans;
    }
}
