package com.algoexpert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 1, 2, 6};
        int[] res = new MergeSort().mergeSort(arr);
        IntStream.range(0, res.length)
                .forEach(idx -> System.out.println(res[idx]));
    }

    public int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return mergeSortArrays(mergeSort(left), mergeSort(right));
    }

    public int[] mergeSortArrays(int[] left, int[] right) {
        int l = 0;
        int r = 0;
        int c = 0;
        int[] sortedArr = new int[left.length + right.length];

        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                sortedArr[c++] = left[l++];
            } else {
                sortedArr[c++] = right[r++];
            }
        }
        while (l < left.length) {
            sortedArr[c++] = left[l++];
        }

        while (r < right.length) {
            sortedArr[c++] = right[r++];
        }

        return sortedArr;
    }
}
