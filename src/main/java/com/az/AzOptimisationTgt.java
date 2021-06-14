package com.az;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/discuss/interview-question/373202/Amazon-or-OA-2019-or-Optimal-Utilization
public class AzOptimisationTgt {
    public static void main(String[] args) {
        //Input:
        //a = [[1, 3], [2, 5], [3, 7], [4, 10]]
        //b = [[1, 2], [2, 3], [3, 4], [4, 5]]
        //target = 10

        List<int[]> a = new ArrayList<>();
        a.add(new int[]{3, 7});
        a.add(new int[]{4, 10});
        a.add(new int[]{2, 5});
        a.add(new int[]{1, 3});

        List<int[]> b = new ArrayList<>();
        b.add(new int[]{1, 2});
        b.add(new int[]{3, 4});
        b.add(new int[]{4, 5});
        b.add(new int[]{2, 3});

        List<int[]> result = getPairs(a, b, 10);

        result.forEach(item -> System.out.println(item[0] + " " + item[1]));
    }

    private static List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
        Collections.sort(a, Comparator.comparingInt(i -> i[1]));
        Collections.sort(b, Comparator.comparingInt(i -> i[1]));
        List<int[]> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int m = a.size();
        int n = b.size();
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            int sum = a.get(i)[1] + b.get(j)[1];
            if (sum > target) {
                --j;
            } else {
                if (max <= sum) {
                    if (max < sum) {
                        max = sum;
                        result.clear();
                    }
                    result.add(new int[]{a.get(i)[0], b.get(j)[0]});
                    int index = j - 1;
                    //corner case
                    while (index >= 0 && b.get(index)[1] == b.get(index + 1)[1]) {
                        result.add(new int[]{a.get(i)[0], b.get(index--)[0]});
                    }
                }
                ++i;
            }
        }
        return result;
    }
}
