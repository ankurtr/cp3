package com.algoexpert;

import java.util.*;
import java.util.stream.IntStream;

class GreedyTasks {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(4);
        System.out.println(new GreedyTasks().taskAssignment(3, list));
    }

    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        Map<Integer, List<Integer>> indexes = organizeIndexes(tasks);
        System.out.println(indexes);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int len = tasks.size();

        int task1, task2, task1Idx, task2Idx;
        Collections.sort(tasks);

        for (int i = 0, j = len - 1; i < len / 2 && j > 0; i++, j--) {
            task1 = tasks.get(i);
            task2 = tasks.get(j);

            task1Idx = indexes.get(task1).get(indexes.get(task1).size() - 1);
            task2Idx = indexes.get(task2).get(indexes.get(task2).size() - 1);

            ArrayList<Integer> r = new ArrayList<>();
            r.add(task1Idx);
            r.add(task2Idx);
            result.add(r);

            indexes.get(task1).remove(indexes.get(task1).size() - 1);
            indexes.get(task2).remove(indexes.get(task2).size() - 1);
        }

        return result;
    }

    public Map<Integer, List<Integer>> organizeIndexes(ArrayList<Integer> tasks) {
        Map<Integer, List<Integer>> indexes = new HashMap<>();
        IntStream.range(0, tasks.size())
                .forEach(i -> {
                    if (indexes.containsKey(tasks.get(i))) {
                        indexes.get(tasks.get(i)).add(i);
                    } else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(i);
                        indexes.put(tasks.get(i), list);
                    }
                });

        return indexes;
    }

}

