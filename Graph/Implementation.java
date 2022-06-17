package com.dataStructure.graph;

import java.util.ArrayList;

public class Implementation {
    private static int[][] graph = new int[5][5];
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public static void main(String[] args) {
        makeGraph(0, 1);
        makeGraph(0, 4);
        makeGraph(4, 3);
        makeGraph(4, 1);
        makeGraph(3, 1);
        makeGraph(2, 1);
        makeGraph(2, 3);

        for (int i = 0; i < 5; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    private static void makeGraph(int u, int v) {
        graph[u][v] = graph[v][u] = 1;
    }
}
