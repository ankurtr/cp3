package com.algoexpert;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class BFS {
    // Do not edit the class below except
    // for the breadthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            ArrayDeque<Node> queue = new ArrayDeque<>();
            queue.offerLast(this);

            while(!queue.isEmpty()) {
                Node node = queue.pollFirst();
                array.add(node.name);
                if (node.children != null) {
                    node.children.forEach(queue::offerLast);
                }
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
