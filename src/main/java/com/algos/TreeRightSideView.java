package com.algos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRightSideView {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            offer(root);
            offer(null);
        }};
        TreeNode prev, curr = root;
        List<Integer> rightside = new ArrayList();

        while (!queue.isEmpty()) {
            prev = curr;
            curr = queue.poll();

            while (curr != null) {
                // add child nodes in the queue
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }

                prev = curr;
                curr = queue.poll();
            }

            // the current level is finished
            // and prev is its rightmost element
            rightside.add(prev.val);
            // add a sentinel to mark the end
            // of the next level
            if (!queue.isEmpty())
                queue.offer(null);
        }
        return rightside;
    }
}
