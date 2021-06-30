package com.leetcode.contest;

import java.util.*;

class NTopoSort {

    public static void main(String[] args) {
        System.out.println(new NTopoSort().waysToBuildRooms(new int[]{-1, 0, 1}));
    }

    public int waysToBuildRooms(int[] prevRoom) {
        int nways = 0;
        if (prevRoom == null || prevRoom.length == 0) {
            return nways;
        }

        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < prevRoom.length; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prevRoom.length; i++) {
            if (prevRoom[i] != -1) {
                graph.get(prevRoom[i]).add(i);
                inDegree.put(i, inDegree.get(i) + 1);
            }
        }

        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        HashSet<List<Integer>> result = new HashSet<>();

        printAllTopoSorts(graph, inDegree, sources, new ArrayList<>(), result);

        return result.size();
    }

    // makes a deep copy of the queue
    private Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num : queue)
            clone.add(num);
        return clone;
    }

    private void printAllTopoSorts(HashMap<Integer, List<Integer>> graph, HashMap<Integer, Integer> inDegree,
                                   Queue<Integer> sources, List<Integer> sortedOrder, HashSet<List<Integer>> nways) {
        if (!sources.isEmpty()) {
            for (Integer vertex : sources) {
                sortedOrder.add(vertex);
                Queue<Integer> sourcesForNextCall = cloneQueue(sources);
                sourcesForNextCall.remove(vertex);

                List<Integer> children = graph.get(vertex);

                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0) {
                        sourcesForNextCall.add(child);
                    }
                }

                printAllTopoSorts(graph, inDegree, sourcesForNextCall, sortedOrder, nways);

                sortedOrder.remove(vertex);

                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) + 1);
                }
            }
        }

        if (sortedOrder.size() == inDegree.size()) {
            nways.add(new ArrayList<>(sortedOrder));
        }

    }
}