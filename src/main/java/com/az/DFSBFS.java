package com.az;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*class Node {
    String name;
    List<Node> children = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public Node addChild(String name) {
        Node child = new Node(name);
        this.children.add(child);
        return child;
    }

    public List<String> dfs(List<String> array) {
        array.add(this.name);
        this.children.forEach(child -> this.dfs(array));
        return array;
    }
}*/

class Node {
    private int element;
    private Node left;
    private Node right;

    public Node(int element) {
        this.element = element;
    }

    public int getElement() {
        return element;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

public class DFSBFS {

    public static void dfs(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.getElement());
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }
    }

    public static void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.getElement());
            if (current.getLeft() != null) {
                queue.offer(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.offer(current.getRight());
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node rootLeft = new Node(2);
        Node rootRight = new Node(3);
        root.setLeft(rootLeft);
        root.setRight(rootRight);
        Node rootLeftLeft = new Node(4);
        Node rootLeftRight = new Node(5);
        rootLeft.setLeft(rootLeftLeft);
        rootLeft.setRight(rootLeftRight);
        Node rootRightLeft = new Node(6);
        Node rootRightRight = new Node(7);
        rootRight.setLeft(rootRightLeft);
        rootRight.setRight(rootRightRight);

        //dfs(root);
        bfs(root);
    }
}
