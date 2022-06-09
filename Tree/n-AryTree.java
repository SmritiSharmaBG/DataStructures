package com.dataStructure.tree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    static class Node {
        public int val;
        public List<Node> children = new ArrayList<>();

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        root.children.add(new Node(4));
        root.children.add(new Node(5));

        root.children.get(1).children.add(new Node(6));
        root.children.get(1).children.add(new Node(7));
        root.children.get(2).children.add(new Node(8));
        root.children.get(3).children.add(new Node(9));
        root.children.get(3).children.add(new Node(10));

        root.children.get(1).children.get(1).children.add(new Node(11));
        root.children.get(2).children.get(0).children.add(new Node(12));
        root.children.get(3).children.get(0).children.add(new Node(13));

        root.children.get(1).children.get(1).children.get(0).children.add(new Node(14));
    }
}
