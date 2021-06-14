package com.leetcode.contest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class SingleThreadedCpu {

    public static void main(String[] args) {
        int[][] tasks = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        System.out.println(Arrays.toString(getOrder(tasks)));
    }

    public static int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        int[][] extTasks = new int[n][3];

        IntStream.range(0, extTasks.length)
                .forEach(index -> {
                    extTasks[index][0] = index;
                    extTasks[index][1] = tasks[index][0];
                    extTasks[index][2] = tasks[index][1];
                });

        //negative = ascending
        //positive = descending
        //zero = as is
        // (napad)
        Arrays.sort(extTasks, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);

        int time = 0;
        int ti = 0, ai = 0;

        while (ai < n) {
            while (ti < n && time >= extTasks[ti][1]) {
                queue.offer(extTasks[ti++]);
            }
            if (queue.isEmpty()) {
                time = extTasks[ti][1];
                continue;
            }
            int[] t = queue.poll();
            if (t != null) {
                ans[ai++] = t[0];
                time += t[2];
            }
        }

        /*IntStream.range(0, tasks.length)
                .forEach(index -> System.out.println(Arrays.toString(tasks[index])));*/
        return ans;
    }
}
