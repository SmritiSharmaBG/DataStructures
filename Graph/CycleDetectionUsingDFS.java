package com.dataStructure.graph;

import java.util.ArrayList;

public class CycleDetectionUsingDFS {
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static boolean[] vis = new boolean[12];

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

        System.out.println(detectCycleDFS(3));
    }

    private static boolean detectCycleDFS(int start) {
        return performRecursion(start, -1);
    }

    /**
     * We are trying to detect cycle in a un-directed graph while traversing using DFS concept.
     * Cycle is there if a node has been visited and also it was not the parent of the node we are currently traversing
     *
     * @param element
     * @param parent
     * @return
     */
    private static boolean performRecursion(int element, int parent) {
        vis[element] = true;
        for (int it : adj.get(element)) {
            if (!vis[it]) {
                if (performRecursion(it, element)) return true;
            } else if (it != parent) return true;
        }
        return false;
    }

    private static void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
