package com.dataStructure.binaryTree;

public class Traversal {
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

        System.out.print("\nPRE-ORDER TRAVERSAL -->");
        preOrder(node); // node -> left -> right
        System.out.print("\nIN-ORDER TRAVERSAL -->");
        inOrder(node); // left -> node -> right
        System.out.print("\nPOST-ORDER TRAVERSAL -->");
        postOrder(node); // left -> node -> right
    }

    private static void postOrder(Node node) {
        if(node == null)
            return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.data+" ");
    }

    private static void inOrder(Node node) {
        if(node == null)
            return;
        preOrder(node.left);
        System.out.print(node.data+" ");
        preOrder(node.right);
    }

    private static void preOrder(Node node) {
        if(node == null)
            return;
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
}
