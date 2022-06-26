package com.dataStructure.graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortingDFS {
    public static class Graph {
        private ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        Graph(int size) {
            for (int i = 0; i < size; i++) graph.add(new ArrayList<>());
        }

        public void addEdge(int u, int v) {
            graph.get(u).add(v);
        }

        public ArrayList<Integer> get(int i) {
            return graph.get(i);
        }
    }

    private static int size;
    private static boolean[] vis;
    private static Stack<Integer> stack = new Stack<Integer>();
    private static Graph adj;

    public static void main(String[] args) {
        size = 6;
        vis = new boolean[size];
        adj = new Graph(size);
        adj.addEdge(5, 2);
        adj.addEdge(5, 0);
        adj.addEdge(4, 0);
        adj.addEdge(4, 1);
        adj.addEdge(2, 3);
        adj.addEdge(3, 1);

        for (int i = 0; i < size; i++) if (!vis[i]) topo(i);
        for (int i = 0; i < size; i++) System.out.print(stack.pop() + " ");
    }

    private static void topo(int i) {
        vis[i] = true;
        for (int it : adj.get(i)) if (!vis[it]) topo(it);
        stack.push(i);
    }
}
