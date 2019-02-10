package com.ds;

import java.util.Stack;

/**
 * Created by trapaank1 on 09/02/19.
 */
public class ConnectedComponents {

    private static boolean[] visited;

    public static void main(String[] args) {
        BasicGraph graph = new BasicGraph(6);
        visited = new boolean[6];
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(5, 5);

        graph.printGraph();

        int connectedComponents = 0;
        for (int i = 1; i < 6; i++) {
            connectedComponents += dfs(graph, i);
        }
        System.out.println("connected components :" + connectedComponents);
    }

    private static int dfs(BasicGraph graph, int v) {
        if (!visited[v]) {
            visited[v] = true;
            Stack<Integer> neighboursToVisit = null;
            for (AdjacentNode neighbour : graph.getAdjacentNodes(v)) {
                if (!visited[neighbour.nodeValue]) {
                    neighboursToVisit = new Stack<>();
                    neighboursToVisit.push(neighbour.nodeValue);
                }
            }
            while (neighboursToVisit != null && !neighboursToVisit.isEmpty()) {
                dfs(graph, neighboursToVisit.pop());
            }
            return 1;
        }
        return 0;
    }
}
