package com.leetcode;

import java.util.Stack;

public class NextGreaterElement {

    static void printNextGE(int arr[], int n) {
        Stack<Integer> stack = new Stack<>();

        int[] arr1 = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                arr1[i] = -1;
            } else {
                arr1[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " --> " + arr1[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 2, 25};
        int n = arr.length;
        printNextGE(arr, n);
    }
}
