package com.az;

import java.util.ArrayList;
import java.util.List;

public class ItemsInContainerAzOA {

    public static void main(String[] args) {
        String s = "|**|*|*";
        List<Integer> startIndices = new ArrayList<>();
        startIndices.add(1);
        startIndices.add(1);
        List<Integer> endIndices = new ArrayList<>();
        endIndices.add(5);
        endIndices.add(6);

        System.out.println(numberOfItems(s, startIndices, endIndices));
    }

    public static List<Integer> numberOfItems(String s, List<Integer> ix, List<Integer> jx) {
        int[] mem = new int[s.length()];

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                mem[i] = count;
            } else {
                count++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < ix.size(); i++) {
            int start = ix.get(i) - 1;
            int end = jx.get(i) - 1;

            while (start < end && s.charAt(start) != '|') start++;
            while (start < end && s.charAt(end) != '|') end--;

            ans.add(mem[end] - mem[start]);
        }
        return ans;
    }
}
