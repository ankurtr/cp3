package com.az;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class RelativeSorting {

    public static void main(String[] args) {
        int[] result = RelativeSorting.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
                new int[]{2, 1, 4, 3, 9, 6});

        IntStream.range(0, result.length)
                .forEach(index -> System.out.print(result[index] + " "));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] newArr = new int[arr1.length];

        Map<Integer, Integer> bitMap = new HashMap<>();
        Map<Integer, Integer> reverseBitMap = new HashMap<>();

        IntStream.range(0, arr2.length)
                .forEach(index -> bitMap.put(arr2[index], -((index + 1) * 10)));

        for (int i = 0; i < arr1.length; i++) {
            if (bitMap.containsKey(arr1[i])) {
                newArr[i] = bitMap.get(arr1[i]);
            } else {
                newArr[i] = arr1[i];
            }
        }

        Integer[] anotherArray = new Integer[newArr.length];
        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] < 0) {
                anotherArray[i] = newArr[i];
            } else {
                anotherArray[i] = Integer.MIN_VALUE;
            }
        }

        Arrays.sort(newArr);
        Arrays.sort(anotherArray, Comparator.reverseOrder());

        for (Map.Entry<Integer, Integer> entry : bitMap.entrySet()) {
            reverseBitMap.put(Math.abs(entry.getValue()) - 1, entry.getKey());
        }

        for (int i = 0; i < anotherArray.length; i++) {
            if (anotherArray[i] < 0) {
                newArr[i] = reverseBitMap.get(Math.abs(anotherArray[i]) - 1);
            }
        }
        return newArr;
    }
}
