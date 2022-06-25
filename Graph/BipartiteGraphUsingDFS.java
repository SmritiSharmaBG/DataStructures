package com.dataStructure.graph;

import java.util.ArrayList;

public class BipartiteGraphUsingDFS {
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
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
        colour[0] = 1;
        System.out.println(checkBipartite(1));

    }

    private static boolean checkBipartite(int node) {
        for (int it : adj.get(node)) {
            if (colour[it] == -1) {
                colour[it] = colour[node] == 1 ? 0 : 1;
                if (!checkBipartite(it)) return false;
            } else if (colour[it] == colour[node]) return false;
        }
        return true;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
