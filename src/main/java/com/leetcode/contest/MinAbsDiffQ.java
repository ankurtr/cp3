package com.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

public class MinAbsDiffQ {
    public static void main(String[] args) {
        //int[] nums = {1, 3, 4, 8};
        int[] nums = {4, 2, 3, 1};
        int[][] queries = {{0, 1}, {1, 2}, {2, 3}, {0, 3}};
        int[] res = new MinAbsDiffQ().minDifference(nums, queries);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public int[] minDifference(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] count = new int[n + 1][5];
        int q = queries.length;
        int ans[] = new int[q];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 5; ++j)
                count[i + 1][j] = count[i][j];

            ++count[i + 1][nums[i] - 1];
        }

        for (int i = 0; i < q; ++i) {
            int low = queries[i][0];
            int high = queries[i][1] + 1;
            List<Integer> present = new ArrayList<>();
            int min = 5;

            for (int j = 0; j < 5; ++j)
                if (count[high][j] - count[low][j] != 0)
                    present.add(j);

            for (int j = 1; j < present.size(); ++j)
                min = Math.min(min, present.get(j) - present.get(j - 1));

            if (present.size() == 1)
                min = -1;

            ans[i] = min;
        }

        return ans;
    }
}
