package com.algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSorting {

    public static void main(String[] args) {
        List<Integer> jobs = new ArrayList<>();
        jobs.add(1);
        jobs.add(2);
        jobs.add(3);
        jobs.add(4);

        List<Integer[]> deps = new ArrayList<>();
        deps.add(new Integer[]{1, 2});
        deps.add(new Integer[]{1, 3});
        deps.add(new Integer[]{3, 2});
        deps.add(new Integer[]{4, 2});
        //deps.add(new Integer[]{4, 3}); //uncomment for cycle
        deps.add(new Integer[]{3, 4});

        //1 - {}
        //2 - {1,3,4}
        //3 - {1,4}
        //4 - {3}

        System.out.println(topologicalSort(jobs, deps));
    }

    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph jobGraph = createJobGraph(jobs, deps);
        return getOrderedJobs(jobGraph);
    }

    public static JobGraph createJobGraph(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph graph = new JobGraph(jobs);
        for (Integer[] dep : deps) {
            graph.addPrereq(dep[1], dep[0]);
        }
        return graph;
    }

    public static List<Integer> getOrderedJobs(JobGraph graph) {
        List<Integer> orderedJobs = new ArrayList<>();
        List<JobNode> nodes = new ArrayList<>(graph.nodes);
        while (nodes.size() > 0) {
            JobNode node = nodes.get(nodes.size() - 1);
            nodes.remove(nodes.size() - 1);
            boolean containsCycle = depthFirstTraverse(node, orderedJobs);
            if (containsCycle) return new ArrayList<>();
        }
        return orderedJobs;
    }

    //1 - {}
    //2 - {1,3,4}
    //3 - {1}
    //4 - {3} -1(true) 1-3-4
    public static boolean depthFirstTraverse(JobNode node, List<Integer> orderedJobs) {
        if (node.visited) return false;
        if (node.visiting) return true;
        node.visiting = true;
        for (JobNode prereqNode : node.preReqs) {
            boolean containsCycle = depthFirstTraverse(prereqNode, orderedJobs);
            if (containsCycle) return true;
        }
        node.visited = true;
        //node.visiting = false;
        orderedJobs.add(node.job);
        return false;
    }

    static class JobGraph {
        public List<JobNode> nodes;
        public Map<Integer, JobNode> graph;

        public JobGraph(List<Integer> jobs) {
            nodes = new ArrayList<>();
            graph = new HashMap<>();
            for (Integer job : jobs) {
                addNode(job);
            }
        }

        public void addPrereq(Integer job, Integer prereq) {
            JobNode jobNode = getNode(job);
            JobNode prereqNode = getNode(prereq);
            jobNode.preReqs.add(prereqNode);
        }

        public void addNode(Integer job) {
            graph.put(job, new JobNode(job));
            nodes.add(graph.get(job));
        }

        public JobNode getNode(Integer job) {
            if (!graph.containsKey(job)) addNode(job);
            return graph.get(job);
        }
    }

    static class JobNode {
        public Integer job;
        public List<JobNode> preReqs;
        public boolean visited;
        public boolean visiting;

        public JobNode(Integer job) {
            this.job = job;
            preReqs = new ArrayList<>();
            visited = false;
            visiting = false;
        }
    }
}
