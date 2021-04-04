package com.algoexpert;

import java.util.Stack;

public class NodeDepthSum {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.right = new BinaryTree(3);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        System.out.println(nodeDepths(root));
        // 1
        // 2 3
        // 4 5 6 7
    }

    public static int nodeDepths(BinaryTree root) {
        Stack<Level> stack = new Stack<>();
        int sumOfDepths = 0;
        stack.push(new Level(root, 0));
        while (!stack.isEmpty()) {
            Level top = stack.pop();
            BinaryTree node = top.node;
            int depth = top.depth;
            if (node == null) {
                continue;
            }
            sumOfDepths += depth;
            stack.push(new Level(node.left, top.depth + 1));
            stack.push(new Level(node.right, top.depth + 1));
        }
        return sumOfDepths;
    }

    static class Level {
        private final BinaryTree node;
        int depth;

        public Level(BinaryTree node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    static class BinaryTree {
        int value;
        public BinaryTree left;
        public BinaryTree right;


        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
