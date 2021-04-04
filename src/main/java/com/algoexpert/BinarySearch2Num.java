package com.algoexpert;

import java.util.Arrays;

public class BinarySearch2Num {
    public static void main(String[] args) {
        int[] expected = {8, 9};
        int[] result = twoNumberSum(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 17);
        System.out.println(Arrays.equals(result, expected));
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        if (array == null || array.length == 0) {
            return new int[]{};
        }
        // Write your code here.
        Arrays.sort(array);
        int l = 0;
        int r = array.length - 1;
        int[] result;
        while (l < r) {
            if (array[l] + array[r] > targetSum)
                r--;
            else if (array[l] + array[r] < targetSum)
                l++;
            else {
                result = new int[]{array[l], array[r]};
                return result;
            }
        }
        return new int[]{};
    }
}
