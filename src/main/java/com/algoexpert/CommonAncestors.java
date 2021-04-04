package com.algoexpert;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommonAncestors {
    // 1
    // 2 3
    // 4 5 6 7
    public static void main(String[] args) {
        TreeNode leaf1 = new TreeNode(4, null, null);
        TreeNode leaf2 = new TreeNode(5, null, null);
        TreeNode leaf3 = new TreeNode(6, null, null);
        TreeNode leaf4 = new TreeNode(7, null, null);
        TreeNode level1Node1 = new TreeNode(2, leaf1, leaf2);
        TreeNode level1Node2 = new TreeNode(3, leaf3, leaf4);
        TreeNode root = new TreeNode(1, level1Node1, level1Node2);

        System.out.println(findLCA(root, leaf3, leaf4).value);
    }


    private static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == null) {
            return q;
        }
        if (q == null) {
            return p;
        }
        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        populateParentMap(root, map);
        Set<TreeNode> visited = new HashSet<>();

        while (p != null) {
            visited.add(map.get(p));
            p = map.get(p);
        }

        TreeNode lca = null;

        while (q != null) {
            if (visited.contains(q)) {
                lca = q;
                break;
            }
            q = map.get(q);
        }
        return lca;
    }

    private static void populateParentMap(TreeNode node, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;

        if (left != null) {
            parentMap.put(left, node);
        }
        if (right != null) {
            parentMap.put(right, node);
        }
        populateParentMap(left, parentMap);
        populateParentMap(right, parentMap);
    }


    private static class TreeNode {
        private final int value;
        private final TreeNode left;
        private final TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
