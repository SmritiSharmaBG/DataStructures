package com.dataStructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static int n;

    public static void main(String[] args) {
        n = 8;
        for (int i = 0; i < n; i++) adj.add(new ArrayList<Integer>());

        addEdge(0, 1);
        addEdge(0, 3);
        addEdge(1, 2);
        addEdge(3, 4);
        addEdge(3, 7);
        addEdge(4, 5);
        addEdge(4, 6);
        addEdge(4, 7);
        addEdge(5, 6);
        addEdge(6, 7);

        int[] ans = getShortestPath(0, 7);
        for (int i : ans) System.out.print(i + " ");
    }

    private static int[] getShortestPath(int src, int des) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n];
        // initialize distance array with largest integer
        for (int i = 0; i < n; i++) distance[i] = Integer.MAX_VALUE;

        // add src in queue and initialize its distance as 0
        queue.add(src);
        distance[src] = 0;

        // traverse the adjacent nodes and their distance will be distance[node] + 1 as they are adjacent
        // keep finding the minimum distance
        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (int it : adj.get(node)) {
                int temp = distance[node] + 1;
                if (temp < distance[it]) {
                    distance[it] = temp;
                    queue.add(it);
                }
            }
        }

        return distance;
    }

    private static void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
