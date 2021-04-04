package com.algoexpert;

import java.util.Arrays;

public class WaterStorage {
    public static void main(String[] args) {
        System.out.println(waterArea(new int[]{0, 1, 0, 1, 0, 2, 0, 3}));
    }

    public static int waterArea(int[] heights) {
        int[] leftMaxHeights = new int[heights.length];
        int[] rightMaxHeights = new int[heights.length];
        int[] contribution = new int[heights.length];

        int maxLeftHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            leftMaxHeights[i] = maxLeftHeight;
            maxLeftHeight = Math.max(maxLeftHeight, heights[i]);
        }

        int maxRightHeight = 0;
        for (int i = heights.length - 1; i > 0; i--) {
            rightMaxHeights[i] = maxRightHeight;
            maxRightHeight = Math.max(maxRightHeight, heights[i]);
        }

        int minHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            minHeight = Math.min(leftMaxHeights[i], rightMaxHeights[i]);
            if (heights[i] < minHeight) {
                contribution[i] = minHeight - heights[i];
            }
        }
        return Arrays.stream(contribution).sum();
    }
}
