package com.az;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

    public static void main(String[] args) {
        int[][] items = new int[][]{{1, 2}, {4, 3}, {5, 6}, {6, 7}};
        System.out.println(knapsackProblem(items, 10));
    }

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int[][] knapsackValues = new int[items.length + 1][capacity + 1];

        for (int i = 1; i < items.length + 1; i++) {
            int currentWeight = items[i - 1][1];
            int currentValue = items[i - 1][0];

            for (int j = 0; j < capacity + 1; j++) {

                if (currentWeight > j) {
                    knapsackValues[i][j] = knapsackValues[i - 1][j];
                } else {
                    knapsackValues[i][j] = Math.max(knapsackValues[i - 1][j],
                            knapsackValues[i - 1][j - currentWeight] + currentValue);
                }
            }
        }
        return getKnapsackitems(knapsackValues, items, capacity);
    }

    public static List<List<Integer>> getKnapsackitems(int[][] knapsackValues,
                                                       int[][] items, int weight) {
        List<List<Integer>> sequence = new ArrayList<>();
        List<Integer> totalWeight = new ArrayList<>();

        totalWeight.add(weight);
        sequence.add(totalWeight);
        sequence.add(new ArrayList<>());

        int i = knapsackValues.length - 1;
        int c = knapsackValues[0].length - 1;

        while (i > 0) {
            if (knapsackValues[i][c] == knapsackValues[i - 1][c]) {
                i--;
            } else {
                sequence.get(1).add(0, i - 1);
                c -= items[i - 1][1];
                i--;
            }
            if (c == 0) {
                break;
            }
        }
        return sequence;
    }
}
