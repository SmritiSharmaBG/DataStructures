package com.dataStructure.BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Insertion {
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
        for(int i = 0; i < size; i ++) {
            System.out.println("Enter the number to be inserted");
            root = insert(root, Integer.parseInt(br.readLine()));
            System.out.println("Element inserted !");
        }
        System.out.println("Elements inserted as -- ");
        inorder(root);
    }

    private static void inorder(Node root) {
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.data+ " ");
        inorder(root.right);
    }

    private static Node insert(Node root, int x) {
        if(root == null) {
            root = new Node(x);
            return root;
        }
        if(x < root.data) root.left = insert(root.left, x);
        else root.right = insert(root.right, x);
        return root;
    }
}
