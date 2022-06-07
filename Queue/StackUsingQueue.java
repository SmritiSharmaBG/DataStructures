package com.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * INPUT 1--
 * push(2)
 * push(3)
 * pop()
 * push(4)
 * pop()
 * end
 * OUTPUT 1--
 * 3 4
 * <p>
 * INPUT 2 --
 * push(2)
 * pop()
 * pop()
 * push(3)
 * end
 * OUTPUT 2 --
 * 2 -1
 * <p>
 * Note -- The code keeps on taking input untill values other than "push(value)" and "pop()" is given
 */
public class StackUsingQueue {
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while (true) {
            line = br.readLine();
            if (line.contains("push")) {
                push(Integer.parseInt(line.substring(5, line.length() - 1)));
            } else if (line.contains("pop")) {
                System.out.println(pop());
            } else {
                System.out.println("Invalid Operation");
                break;
            }
        }
    }

    private static int pop() {
        if (queue.size() == 0)
            return -1;
        return queue.remove();
    }

    private static void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
    }
}
