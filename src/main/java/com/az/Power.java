package com.az;

import java.util.PriorityQueue;

public class Power {
    public static void main(String[] args) {
        System.out.println(power(2, 3));
        PriorityQueue<Integer> queue = new PriorityQueue<>();

    }

    private static int power(int x, int n) {
        if (n == 0)
            return 1;
        else if (n % 2 == 0)
            return power(x, n / 2) * power(x, n / 2);
        else
            return x * power(x, n / 2) * power(x, n / 2);
    }
}
