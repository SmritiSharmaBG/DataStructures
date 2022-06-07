package com.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * INPUT 1--
 * enqueue(2)
 * enqueue(3)
 * dequeue()
 * enqueue(4)
 * dequeue()
 * end
 * OUTPUT 1--
 * 2 3
 * <p>
 * INPUT 2 --
 * enqueue(2)
 * dequeue()
 * dequeue()
 * end
 * OUTPUT 2 --
 * -1
 * <p>
 * Note -- The code keeps on taking input untill values other than "enqueue(value)" and "dequeue" is given
 */
public class QueueUsingStack {
    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while (true) {
            line = br.readLine();
            if (line.contains("enqueue")) {
                enqueue(Integer.parseInt(line.substring(8, line.length() - 1)));
            } else if (line.contains("dequeue")) {
                dequeue();
            } else {
                System.out.println("Invalid Operation");
                break;
            }
        }
    }

    private static void dequeue() {
        if (stack1.isEmpty()) {
            System.out.println(-1);
            return;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        System.out.println(stack2.pop());
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    private static void enqueue(int x) {
        stack1.push(x);
    }
}
