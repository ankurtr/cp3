package com.cp3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ankur on 26/3/17.
 */
public class ArraySum {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = 0;
        int X = 0;
        int[] arr = null;

        while (T-- > 0) {
            N = sc.nextInt();
            X = sc.nextInt();
            if (N > 0) {
                arr = new int[N];
                for (int i = 0; i < N; i++) {
                    arr[i] = sc.nextInt();
                }
                if (isSumPresent_(arr, X)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static boolean isSumPresent(int[] arr, int n) {
        Map<Integer, Integer> ref = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            ref.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            int x = n - arr[i];
            if (ref.containsKey(x)) {
                return true;
            }
        }
        return false;
    }


    public static boolean isSumPresent_(int[] arr, int n) {
        Arrays.sort(arr);

        int l, r;
        for (l = 0, r = arr.length - 1; l < r; ) {
            if (arr[l] + arr[r] > n)
                r--;
            else if (arr[l] + arr[r] < n) {
                l++;
            } else if (arr[l] + arr[r] == n) {
                return true;
            }
        }
        return false;
    }


}
