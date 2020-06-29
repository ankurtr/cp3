package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
    int number;
    TreeNode left;
    TreeNode right;

    public TreeNode(int number, TreeNode left, TreeNode right) {
        this.number = number;
        this.left = left;
        this.right = right;
    }
}

public class BottomOrderTreeTraversal {

    private static List<List<Integer>> levels = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, null);
        TreeNode rootLeft = addNodeToTree(root, 2);
        TreeNode rootRight = addNodeToTree(root, 3);
        TreeNode rootLeftLeft = addNodeToTree(rootLeft, 4);
        TreeNode rootLeftRight = addNodeToTree(rootLeft, 5);
        TreeNode rootRightLeft = addNodeToTree(rootRight, 6);
        TreeNode rootRightRight = addNodeToTree(rootRight, 7);

        printTree(root);
        System.out.println(printLevelOrderFromBottom(root));
    }

    static void printTree(TreeNode root) {
        if (root != null) {
            System.out.println(root.number);
            printTree(root.left);
            printTree(root.right);
        }
    }

    static TreeNode addNodeToTree(TreeNode root, int number) {
        TreeNode node = new TreeNode(number, null, null);
        if (root.left == null) {
            root.left = node;
        } else if (root.right == null) {
            root.right = node;
        }
        return node;
    }

    public static List<List<Integer>> printLevelOrderFromBottom(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        Collections.reverse(levels);
        return levels;
    }

    public static void helper(TreeNode node, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(node.number);

        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }
}
