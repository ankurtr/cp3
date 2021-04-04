package com.az;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class top2 {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 5, 2, 7, 2, 7, 4, 7};
        //int[] nums = new int[]{2,1,1,3,2,1,1,3};
        System.out.println(new top2().solution(nums));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> freq = new HashSet<>();

        IntStream.range(0, A.length)
                .forEach(index -> freq.add(A[index]));

        int uniq = freq.size();
        freq.clear();

        int l = 0;
        int r = l + 1;
        int res = Integer.MAX_VALUE;

        freq.add(A[l]);
        while (l < r) {
            if (r < A.length - 1) {
                freq.add(A[r]);
            }
            if (freq.size() == uniq) {
                res = Math.min(res, (r - l) + 1);
                l++;
                freq.remove(A[l - 1]);
            } else {
                r++;
            }
        }

        return res;
    }
}
