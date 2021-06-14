package com.leetcode.contest;

import java.util.Arrays;

public class MaximumXorForEachQuery {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMaximumXor(new int[]{0, 1, 1, 3}, 2)));
        System.out.println(Arrays.toString(getMaximumXor(new int[]{2, 3, 4, 7}, 3)));
    }

    //https://leetcode.com/problems/maximum-xor-for-each-query/discuss/1163057/Easy-O(N)-Solution-w-Explanation-or-Max-XOR-2maximumBit-1
    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] result = new int[nums.length];

        int target = (1 << maximumBit) - 1;

        int XOR = 0;

        for (int n : nums) {
            XOR ^= n;
        }

        result[0] = XOR ^ target;

        for (int i = 1; i < nums.length; i++) {
            XOR ^= nums[nums.length - i];
            result[i] = XOR ^ target;
        }

        return result;
    }
}
