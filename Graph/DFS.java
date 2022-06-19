package com.dataStructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFS {
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static ArrayList<Integer> dfs = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        dfs();
        for (int i : dfs) System.out.print(i + " ");
    }

    private static void dfs() {
        boolean[] vis = new boolean[5];
        for (int i = 1; i <= 4; i++) dfs(i, vis);
    }

    private static void dfs(int node, boolean[] vis) {
        vis[node] = true;
        dfs.add(node);
        for (int i : adj.get(node)) {
            if (!vis[i]) dfs(i, vis);
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

}
