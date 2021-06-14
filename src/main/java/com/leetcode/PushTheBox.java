package com.leetcode;

import java.util.Arrays;

public class PushTheBox {
    public static void main(String[] args) {
        //int[] boxes = new int[]{4, 3, 4, 1};
        //int[] warehouses = new int[]{5, 3, 3, 4, 1};
        int[] boxes = new int[]{1, 2, 2, 3, 4};
        int[] warehouses = new int[]{3, 4, 1, 2};

        System.out.println(maxBoxesInWarehouse(boxes, warehouses));
    }

    private static int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int maxBoxes = 0;
        int[] validRooms = new int[warehouse.length];
        Arrays.sort(boxes);

        validRooms[0] = warehouse[0];
        for (int i = 1; i < warehouse.length; i++) {
            validRooms[i] = Math.min(validRooms[i - 1], warehouse[i]);
        }

        Arrays.sort(boxes);
        for (int j = 0, i = validRooms.length - 1; j < boxes.length && i >= 0; j++, i--) {
            while (i >= 0 && boxes[j] > validRooms[i]) {
                i--;
            }
            if (i >= 0 && boxes[j] <= validRooms[i]) {
                maxBoxes++;
                //i--;
            }
        }
        return maxBoxes;
    }
}
