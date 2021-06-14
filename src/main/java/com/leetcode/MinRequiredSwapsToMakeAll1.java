package com.leetcode;

import java.util.Arrays;

public class MinRequiredSwapsToMakeAll1 {

    public static void main(String[] args) {
        //int arr[] = new int[]{1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1};
        //int arr[] = new int[]{0, 0, 0, 1, 0};
        int arr[] = {1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1};
        //int[] arr = {1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1};
        System.out.println(minSwaps(arr, findNumberOfOnes(arr)));
    }

    private static int findNumberOfOnes(int[] arr) {
        return (int) Arrays.stream(arr).filter(i -> i == 1).count();
    }

    private static int minSwaps(int[] arr, int oneCount) {
        int numberOfOnesInWindow = 0;
        int minSwaps = Integer.MAX_VALUE;
        if (oneCount == 1) {
            return 0;
        }
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1) {
                numberOfOnesInWindow++;
            }
            if (windowEnd - windowStart + 1 >= oneCount) {
                minSwaps = Math.min(minSwaps, (windowEnd - windowStart + 1) - numberOfOnesInWindow);
                if (arr[windowStart] == 1) {
                    numberOfOnesInWindow--;
                }
                windowStart += 1;
            }
        }
        return minSwaps;
    }
}
