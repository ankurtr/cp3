package com.leetcode.contest;

public class XorSum {
    public static void main(String[] args) {
        System.out.println(getXORSum(new int[]{1, 2, 3}, new int[]{6, 5}));
        System.out.println(getXORSum(new int[]{12}, new int[]{4}));
    }

    public static int getXORSum(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        int[] andArr = new int[m * n];
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                andArr[cnt++] = (arr1[i] & arr2[j]);
            }
        }

        int result = 0;
        for (int x : andArr) {
            result ^= x;
        }
        return result;
    }
}
