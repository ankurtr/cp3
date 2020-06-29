package com.hr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;

/**
 * https://www.hackerearth.com/challenges/hiring/lazypay-java-developer-hiring-challenge-2019/problems/b153af7398f944f1835014f841a8a79f/
 */

class AdjacentNode {
    Integer nodeValue;
    int stonePile;
    private LinkedList<AdjacentNode> adjacentNodes;

    AdjacentNode(Integer nodeValue, int stonePile) {
        this.nodeValue = nodeValue;
        this.stonePile = stonePile;
        this.adjacentNodes = new LinkedList<>();
    }

    void addAdjacentNode(AdjacentNode anotherNode) {
        Objects.requireNonNull(anotherNode);
        if (!nodeValue.equals(anotherNode.nodeValue)) {
            this.adjacentNodes.add(anotherNode);

        }
    }

    /*public int getStonePile() {
        return this.stonePile;
    }

    public void addAdjacentNode(AdjacentNode anotherNode, Integer stonePile) {
        Objects.requireNonNull(anotherNode);
        if (!nodeValue.equals(anotherNode.nodeValue)) {
            AdjacentNode anotherNewNode = new AdjacentNode(anotherNode.nodeValue, stonePile);
            this.adjacentNodes.add(anotherNewNode);
        }
    }*/

    /*public void printNode() {
        System.out.println("NodeValue " + nodeValue);
        System.out.println("stonePile" + stonePile);
        System.out.println("AdjacentNodes");
        adjacentNodes.forEach(adjacentNode1 -> System.out.println("NodeValue : " + adjacentNode1.nodeValue));
    }*/

}

public class Problem1 {
    private AdjacentNode[] nodes;

    private Problem1(int numberOfVertices) {
        this.nodes = new AdjacentNode[numberOfVertices];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nq = br.readLine().split(" ");
        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);

        String[] stones = br.readLine().split(" ");

        Problem1 basicGraph = new Problem1(n);

        int t = n;
        while (t > 0) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);

            basicGraph.addEdge(u - 1, v - 1, Integer.parseInt(stones[u - 1]),
                    Integer.parseInt(stones[v - 1]));

            t--;
        }

        //basicGraph.printGraph();

        t = q;

        while (t > 0) {
            String[] query = br.readLine().split(" ");
            int v1 = Integer.parseInt(query[0]) - 1;
            int v2 = Integer.parseInt(query[1]) - 1;

            System.out.println(printWinner(basicGraph, v1, v2));
            t--;
        }
    }

    public static String printWinner(Problem1 basicGraph, int V1, int V2) {
        AdjacentNode vertex1 = basicGraph.getVertex(V1);
        AdjacentNode vertex2 = basicGraph.getVertex(V2);

        //same nodes
        if (vertex1.nodeValue.equals(vertex2.nodeValue)) {
            return "Bob";
        } else if (vertex1.stonePile > vertex2.stonePile) {
            return "Bob";
        } else if (vertex2.stonePile > vertex1.stonePile) {
            return "Alex";
        } else {
            //stone piles are equal on diff vertex
            return "Alex";
        }
    }

    private AdjacentNode getVertex(int vertex) {
        return nodes[vertex];
    }

    private void addEdge(Integer nodeValue, Integer anotherNodeValue, Integer stoneWeightU,
                         Integer stoneWeightV) {
        Objects.requireNonNull(nodeValue);
        Objects.requireNonNull(anotherNodeValue);
        Objects.requireNonNull(stoneWeightU);
        Objects.requireNonNull(stoneWeightV);
        if (nodes[nodeValue] == null) {
            AdjacentNode newNode = new AdjacentNode(nodeValue, stoneWeightU);
            nodes[nodeValue] = newNode;
        }
        if (nodes[anotherNodeValue] == null) {
            AdjacentNode newNode = new AdjacentNode(anotherNodeValue, stoneWeightV);
            nodes[anotherNodeValue] = newNode;
        }
        nodes[nodeValue].addAdjacentNode(nodes[anotherNodeValue]);
        nodes[anotherNodeValue].addAdjacentNode(nodes[nodeValue]);
    }

    /*public void printGraph() {
        for (int i = 0; i < numberOfVertices; i++) {
            nodes[i].printNode();
        }
    }*/
}
