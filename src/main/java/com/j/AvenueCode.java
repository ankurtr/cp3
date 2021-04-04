package com.j;

import java.util.ArrayList;
import java.util.List;

public class AvenueCode {

    public static void main(String[] args) {

        List<Integer> k = new ArrayList<>();
        k.add(2);
        k.add(4);

        List<Long> result = new ArrayList<>();
        for (int i = 0; i < k.size(); i++) {
            Long sum = factorsSum(k.get(i));
            result.add(sum);
        }

        System.out.println(result);
    }

    private static Long factorsSum(Integer x) {
        List<Long> factors = new ArrayList<>();
        int xr = (int) Math.sqrt((double) x);
        int incrementer = (x % 2 == 0) ? 1 : 2;
        for (long i = 1; i <= xr; i += incrementer) {
            if (x % i == 0) {
                factors.add(i);

                if (i != x / i) {
                    factors.add(x / i);
                }
            }
        }
        return factors.stream().mapToLong(i -> i).sum();
    }
}
