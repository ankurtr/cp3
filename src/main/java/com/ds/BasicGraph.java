package com.ds;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by trapaank1 on 09/02/19.
 */
class AdjacentNode {
    Integer nodeValue;
    int degree;
    int weight;
    LinkedList<AdjacentNode> adjacentNodes;

    public AdjacentNode(Integer nodeValue) {
        this(nodeValue, 0);
    }

    public AdjacentNode(Integer nodeValue, int weight) {
        this.nodeValue = nodeValue;
        this.weight = weight;
        this.adjacentNodes = new LinkedList<>();
    }

    public void addAdjacentNode(AdjacentNode anotherNode, Integer weight) {
        Objects.requireNonNull(anotherNode);
        if (!nodeValue.equals(anotherNode.nodeValue)) {
            AdjacentNode anotherNewNode = new AdjacentNode(anotherNode.nodeValue, weight);
            this.adjacentNodes.add(anotherNewNode);
            this.degree++;
            anotherNewNode.degree++;
            anotherNode.degree++;
        }
    }

    public void printNode() {
        System.out.println("NodeValue" + nodeValue);
        System.out.println("AdjacentNodes");
        adjacentNodes.forEach(adjacentNode1 -> System.out.println("NodeValue : " + adjacentNode1.nodeValue + ", weight : " + adjacentNode1.weight));
    }
}

public class BasicGraph {
    int numberOfVertices;
    AdjacentNode[] nodes;

    public BasicGraph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        nodes = new AdjacentNode[numberOfVertices];
    }

    public static void main(String[] args) {
        BasicGraph graph = new BasicGraph(5);
        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 7);
        graph.addEdge(4, 1, 5);

        graph.printGraph();

    }

    public LinkedList<AdjacentNode> getAdjacentNodes(int vertice) {
        return nodes[vertice].adjacentNodes;
    }

    public void addEdge(Integer nodeValue, Integer anotherNodeValue) {
        addEdge(nodeValue, anotherNodeValue, 0);
    }

    public void addEdge(Integer nodeValue, Integer anotherNodeValue, Integer weight) {
        Objects.requireNonNull(nodeValue);
        Objects.requireNonNull(anotherNodeValue);
        Objects.requireNonNull(weight);
        if (nodes[nodeValue] == null) {
            AdjacentNode newNode = new AdjacentNode(nodeValue);
            nodes[nodeValue] = newNode;
        }
        if (nodes[anotherNodeValue] == null) {
            AdjacentNode newNode = new AdjacentNode(anotherNodeValue);
            nodes[anotherNodeValue] = newNode;
        }
        nodes[nodeValue].addAdjacentNode(nodes[anotherNodeValue], weight);
        nodes[anotherNodeValue].addAdjacentNode(nodes[nodeValue], weight);
    }

    public void printGraph() {
        for (int i = 1; i < numberOfVertices; i++) {
            nodes[i].printNode();
        }
    }
}
