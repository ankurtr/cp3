package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Pascal {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();

        List<Integer> curr = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            curr.add(0, 1);

            for (int x = 1; x < curr.size() - 1; x++) {
                curr.set(x, curr.get(x) + curr.get(x + 1));
            }

            output.add(new ArrayList<>(curr));
        }
        return output;
    }
}
