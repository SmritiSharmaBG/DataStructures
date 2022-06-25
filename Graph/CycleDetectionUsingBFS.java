package com.dataStructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionUsingBFS {
    private static class Pair {
        int node, parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static boolean[] vis = new boolean[12]; // here the number of nodes is 12

    public static void main(String[] args) {
        for (int i = 0; i <= 12; i++) adj.add(new ArrayList<Integer>());

        addEdge(0, 1);
        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(2, 4);
        addEdge(3, 5);
        addEdge(5, 6);
        addEdge(5, 10);
        addEdge(6, 7);
        addEdge(7, 8);
        addEdge(10, 9);
        addEdge(9, 8);
        addEdge(8, 11);

        System.out.println(detectCycleBFS(3));
    }

    /**
     * Logic : Uses the concept of BFS Traversal
     * Instead of storing only one number, we store a Pair of numbers i.e. node and its parent
     * when a node is visited, check if the parent (in queue) is different from the parent it actually came from (adj list)
     * if different, then it means that cycle is present
     * Why ? : Because here we are talking about un-directed Graph. if 1 is adj to 2, then 2 is adj to 1 as well.
     * So, when checking visited array of 1 (line 68), we see it as visited, it doesn't mean there is a cycle there. 
     *                                       1 -- 2 (element)
     *                                   (parent)
     * It simply means 2 came from 1 while traversal. This is the reason why we keep a parent.  
     * Cycle is there when somehow 1 is visited, and also, 1 was not the parent of 2 (line 72)
     *
     *                                         3 ( parent )
     *                                         |
     *                                    1 -- 2 ( element )
     *                                (visited)
     *
     * @param start the initial starting point
     * @return true if cycle present else false
     */
    private static boolean detectCycleBFS(int start) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, -1));
        vis[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.peek().node;
            int parent = queue.remove().parent;
            for (int it : adj.get(node)) {
                if (!vis[it]) {
                    queue.add(new Pair(it, node));
                    vis[it] = true;
                } else if (vis[it] && it != parent) return true;
            }
        }
        return false;
    }

    private static void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
