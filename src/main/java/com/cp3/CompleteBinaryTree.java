package com.cp3;

/**
 * Created by ankur on 20/4/17.
 */
public class CompleteBinaryTree {

    public int assignvalues(int[] arr, int currentLevel, int maxLevel, int idx, int value) {
        if (currentLevel >= maxLevel || idx >= arr.length) {
            return value;
        }
        int val = assignvalues(arr, currentLevel + 1, maxLevel, (2 * idx) + 1, value);

        value = val + 1;
        arr[idx] = value;

        val = assignvalues(arr, currentLevel + 1, maxLevel, (2 * idx) + 2, value);

        return val;
    }

    public void createBinaryTree(int level) {
        int[] arr = new int[((int) Math.pow(2.0, level)) - 1];

        assignvalues(arr, 0, 3, 0, 0);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}
