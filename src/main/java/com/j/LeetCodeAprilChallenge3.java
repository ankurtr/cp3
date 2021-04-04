package com.j;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class LeetCodeAprilChallenge3 {
    public static void main(String[] args) {
        //System.out.println(largestUniqueNumber(new int[]{5, 7, 3, 9, 4, 9, 8, 3, 1}));
        //System.out.println(largestUniqueNumber(new int[]{9, 9, 8, 8}));

        String x = "hi";
        System.out.println(x.charAt(0));
    }

    public static int largestUniqueNumber(int[] A) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());

        IntStream.range(0, A.length)
                .forEach(index -> {
                    treeMap.put(A[index], treeMap.getOrDefault(A[index], 0) + 1);
                });

        Map.Entry<Integer, Integer> result = treeMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .orElse(null);

        return result == null ? -1 : result.getKey();
    }
}
