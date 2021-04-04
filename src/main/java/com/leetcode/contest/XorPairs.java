package com.leetcode.contest;

import java.util.HashMap;
import java.util.Map;

public class XorPairs {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 2, 7};
        System.out.println(countPairs(nums, 2, 6));
    }

    public static int countPairs(int[] nums, int low, int high) {
        int xorRes = 0;
        int nicePairs = 0;
        /*for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                xorRes=nums[i]^nums[j];
                if(xorRes>=low && xorRes<=high) {
                    nicePairs++;
                }
            }
        }*/
        Map<Integer, Integer> xorValues = new HashMap<>();
        for (int i = low; i <= high; i++) {
            for (int j = 0; j < nums.length; j++) {
                xorValues.put(i ^ nums[j], xorValues.getOrDefault(i ^ nums[j], 0) + 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (xorValues.containsKey(nums[i])) {
                nicePairs += xorValues.get(nums[i]);
            }
        }
        return nicePairs;
    }
}
