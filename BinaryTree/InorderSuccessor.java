package com.dataStructure.BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InorderSuccessor {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of numbers");
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the number to be inserted");
            root = insert(root, Integer.parseInt(br.readLine()));
            System.out.println("Element inserted !");
        }
        System.out.println("Elements inserted as -- ");

        System.out.println("Enter the element whose inorder successor has to be found ");
        int i = Integer.parseInt(br.readLine());
        Node x = getNode(root, i);
        System.out.println("Brute Force - " + inorderSuccessorBrute(x));
        //System.out.println("Using Inorder Traversal" + inorderSuccessorInorder(x));
        System.out.println("Using properties of BST - " + inorderSuccessor(root, x).data);

    }

    // using properties of BST
    private static Node inorderSuccessor(Node root, Node x) {
        Node succ = null;
        while (root != null) {
            if (x.data <= root.data) {
                succ = root;
                root = root.left;
            } else root = root.right;
        }
        return succ;
    }

    // storing inorder sequence in list and iterating over it to find the successor of it
    private static int inorderSuccessorBrute(Node x) {
        List<Integer> list = new ArrayList<>();
        list = inorder(root, list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == x.data)
                if (i < list.size() - 1) return list.get(i + 1);
        }
        return -1;
    }

    private static List<Integer> inorder(Node root, List<Integer> list) {
        if (root == null)
            return list;
        list = inorder(root.left, list);
        list.add(root.data);
        list = inorder(root.right, list);
        return list;
    }

    private static Node getNode(Node root, int i) {
        if (root == null || root.data == i)
            return root;
        if (i < root.data) root = getNode(root.left, i);
        else root = getNode(root.right, i);
        return root;
    }

    private static Node insert(Node root, int x) {
        if (root == null) {
            root = new Node(x);
            return root;
        }
        if (x < root.data) root.left = insert(root.left, x);
        else root.right = insert(root.right, x);
        return root;
    }
}
