package com.j;

import java.util.ArrayList;
import java.util.List;

public class NAryRoot {

    // https://leetcode.com/discuss/interview-question/351946/Google-or-Onsite-or-Find-Root-of-N-ary-Tree

    public static Node findRoot(Node... tree) {
        int root = 0;
        for (Node node : tree) {
            root ^= node.val;
            for (Node child : node.children) {
                root ^= child.val;
            }
        }

        for (Node node : tree) {
            if (node.val == root) return node;
        }

        throw new RuntimeException("not possible");
    }

    public static void main(String[] args) {
        test1();
        //test2();
    }

    private static void test1() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.children.add(n2);
        n1.children.add(n3);
        n1.children.add(n4);
        System.out.println(String.format("Expected 1, actual: %d", findRoot(n2, n3, n4, n1).val));
    }

    private static void test2() {
        Node n1 = new Node(-1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);

        n1.children.add(n2);
        n2.children.add(n3);
        n3.children.add(n4);
        n4.children.add(n5);
        n5.children.add(n6);
        n6.children.add(n7);
        n7.children.add(n8);
        n8.children.add(n9);
        n9.children.add(n10);
        System.out.println(String.format("Expected -1, actual: %d",
                findRoot(n2, n3, n4, n1, n10, n6, n8, n7, n9, n5).val));
    }
}

class Node {
    int val;
    List<Node> children = new ArrayList<>();

    Node(int val) {
        this.val = val;
    }
}
