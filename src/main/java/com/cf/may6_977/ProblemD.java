package com.cf.may6_977;

import java.util.*;

/**
 * Created by trapaank1 on 06/05/18.
 */
public class ProblemD {

    static int[] findStart(int[] arr, Map<Integer, Integer> values) {
        int[] starts = new int[arr.length];
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            if (values.get(arr[i] * 3) != null || (arr[i] % 2 == 0 && values.get(arr[i] / 2) != null)) {
                continue;
            }
            starts[x++] = i;
        }
        return starts;
    }

    static void printOrder(int[] arr) {
        Map<Integer, Integer> values = new HashMap<>();
        int x = 0;
        for (int i : arr) {
            values.put(i, x++);
        }
        int[] starts = findStart(arr, values);

        for (int i = 0; i < starts.length; i++) {
            x = arr.length;
            int startIndex = starts[i];
            while (x-- > 0) {
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] values = new int[n];
            int i = 0;
            while (--n >= 0) {
                values[i++] = sc.nextInt();
            }
            printOrder(values);
        }
    }
}
