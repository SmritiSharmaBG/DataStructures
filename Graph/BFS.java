package com.dataStructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static ArrayList<Integer> bfs = new ArrayList<>();

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

        bfs();
        for (int i : bfs) System.out.print(i + " ");
    }

    /*
    Things to do while adding in queue :
    a. check if the element being added is not visited
    b. mark it visited

    Things to do while removing from queue :
    a. showcase in traversal
    b. add its adjacents in queue
     */
    private static void bfs() {
        boolean[] vis = new boolean[5]; // default value of boolean is false
        for (int i = 1; i <= 4; i++) {
            Queue<Integer> queue = new LinkedList<>();
            if (!vis[i]) {
                queue.add(i);
                vis[i] = true;
                while (!queue.isEmpty()) {
                    int node = queue.remove();
                    bfs.add(node);
                    for (int ad : adj.get(node)) {
                        if (!vis[ad]) {
                            queue.add(ad);
                            vis[ad] = true;
                        }
                    }
                }
            }
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
