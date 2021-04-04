package com.az;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threepairssum {
    public static void main(String[] args) {
        System.out.println(threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0));
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();
        int l = array.length - 1;
        int r = 1, re = l, c = 0, sum;
        while (c < array.length - 2) {
            sum = array[c] + array[r] + array[re];

            if (sum == targetSum) {
                result.add(new Integer[]{c, r, re});
                c += 1;
                r = c + 1;
                re = l;
            } else if (sum < targetSum) {
                r+=1;
            } else {
                re -= 1;
                if (re < c + 2) {
                    c += 1;
                    r = c + 1;
                    re = l;
                }
            }
        }
        return result;
    }
}
