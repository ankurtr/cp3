package com.leetcode.contest;

import java.util.Arrays;

//https://leetcode.com/contest/weekly-contest-239/problems/minimum-interval-to-include-each-query/
public class MinIntervals {

    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] nums = new int[10000000];
        Arrays.fill(nums, -1);

        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];

            int interval = right - left + 1;

            for (int j = left; j <= right; j++) {
                if (nums[j] > interval || nums[j] == -1) {
                    nums[j] = interval;
                }
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = nums[queries[i]];
        }

        return result;
    }
}
