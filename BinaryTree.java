package com.dataStructure.binaryTree;

public class BinaryTree {
    static class Node {
        private int data;
        private Node left;
        private Node right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    /**
     *               10
     *              /  \
     *            11    12
     *           / \   / \
     *         13  14 15 16
     */
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(11);
        node.right = new Node(12);
        node.left.left = new Node(13);
        node.left.right = new Node(14);
        node.right.left = new Node(15);
        node.right.right = new Node(16);
    }
}
