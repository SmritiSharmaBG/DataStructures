package com.dataStructure.binaryTree;

public class FlattenBT {
    static class Node {
        int val;
        Node left, right;

        Node(int data) {
            this.val = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.right = new Node(18);
        root.left.left = new Node(3);
        root.left.right = new Node(7);

        flatten(root);
    }

    /*
    Logic --
    the inorder predecessor of the root should point to the right of the root; and the right of thr root should point to its left; and the left should point to NULL !
     */
    private static void flatten(Node root) {
        Node cur = root;
        while (cur != null) {
            if (cur.left != null) {
                Node inPre = cur.left;
                while (inPre.right != null) inPre = inPre.right;
                inPre.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
