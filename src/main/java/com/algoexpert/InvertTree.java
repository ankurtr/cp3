package com.algoexpert;

import java.util.ArrayDeque;

public class InvertTree {

    private static void invertBinaryTree(BinaryTree root) {
        if (root == null) {
            return;
        }

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);

        BinaryTree temporary = root.left;
        root.left = root.right;
        root.right = temporary;
    }

    public static void main(String[] args) {
        BinaryTree eight = new BinaryTree(8, null, null);
        BinaryTree nine = new BinaryTree(9, null, null);
        BinaryTree four = new BinaryTree(4, eight, nine);
        BinaryTree five = new BinaryTree(5, null, null);
        BinaryTree six = new BinaryTree(6, null, null);
        BinaryTree seven = new BinaryTree(7, null, null);
        BinaryTree two = new BinaryTree(2, four, five);
        BinaryTree three = new BinaryTree(3, six, seven);
        BinaryTree one = new BinaryTree(1, two, three);

        print(one);
        System.out.println("======");
        invertBinaryTree(one);
        System.out.println("======");
        print(one);
    }

    private static void print(BinaryTree root) {
        if (root == null) {
            return;
        }
        print(root.left);
        System.out.println(root.value);
        print(root.right);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value, BinaryTree left, BinaryTree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
