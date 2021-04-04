package com.algoexpert;

import java.util.*;

public class TopoSortMine {

    public static void main(String[] args) {
        List<Integer> jobs = new ArrayList<>();
        jobs.add(1);
        jobs.add(2);
        jobs.add(3);
        jobs.add(4);

        List<int[]> deps = new ArrayList<>();
        deps.add(new int[]{1, 2});
        deps.add(new int[]{3, 2});
        deps.add(new int[]{3, 4});

        Graph graph = createGraph(jobs, deps);

        System.out.println(getOrderedJobs(graph));
    }

    private static Graph createGraph(List<Integer> jobs, List<int[]> deps) {
        Graph graph = new Graph();
        jobs.forEach(graph::addJob);
        deps.forEach(dep -> graph.addDependency(dep[1], dep[0]));
        return graph;
    }

    private static List<Integer> getOrderedJobs(Graph graph) {
        List<Node> nodes = new ArrayList<>(graph.graph.values());
        Collections.shuffle(nodes);
        Node node;
        boolean containsCycle;
        List<Integer> orderedJobs = new ArrayList<>();

        while (!nodes.isEmpty()) {
            node = nodes.get(nodes.size() - 1);
            nodes.remove(node);
            containsCycle = depthFirstSearch(node, orderedJobs);
            if (containsCycle) {
                return new ArrayList<>();
            }
        }
        return orderedJobs;
    }

    public static boolean depthFirstSearch(Node node, List<Integer> orderedJobs) {
        if (node.visited) return false;
        if (node.visiting) return true;

        node.visiting = true;

        for (Node dep : node.preRequisites) {
            if (depthFirstSearch(dep, orderedJobs)) {
                return true;
            }
        }

        node.visited = true;
        orderedJobs.add(node.job);
        return false;
    }

    private static class Graph {
        Map<Integer, Node> graph = new HashMap<>();

        public void addJob(Integer job) {
            Node node = new Node(job);
            graph.put(job, node);
        }

        public Node getJob(Integer job) {
            graph.putIfAbsent(job, new Node(job));
            return graph.get(job);
        }

        public void addDependency(Integer preRequisite, Integer actualJob) {
            getJob(actualJob).preRequisites.add(getJob(preRequisite));
        }

    }

    private static class Node {
        private Integer job;
        List<Node> preRequisites = new ArrayList<>();
        boolean visiting;
        boolean visited;

        public Node(Integer job) {
            this.job = job;
        }
    }
}
