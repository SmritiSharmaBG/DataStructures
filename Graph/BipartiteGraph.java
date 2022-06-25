package com.dataStructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();
    private static int[] colour = new int[9];

    public static void main(String[] args) {
        for (int i = 0; i <= 8; i++) adj.add(new ArrayList<Integer>());
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 5);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 7);
        addEdge(adj, 7, 6);
        addEdge(adj, 7, 8);
        addEdge(adj, 5, 6);
        for (int i = 0; i <= 8; i++) colour[i] = -1;
        System.out.println(checkBipartite(1, 0));

    }

    private static boolean checkBipartite(int node, int col) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        colour[node] = col;
        while (!queue.isEmpty()) {
            int element = queue.remove();
            int elementCol = colour[element];
            for (int it : adj.get(element)) {
                if (colour[it] == -1) {
                    colour[it] = elementCol == 0 ? 1 : 0;
                    queue.add(it);
                } else if (colour[it] == elementCol) return false;
            }
        }
        return true;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
