package com.cf.may6_977;

import java.util.*;

/**
 * Created by trapaank1 on 06/05/18.
 */
public class ProblemC {

    public static int getX(List<Integer> n, int k) {

        Collections.sort(n);

        if (k == -1) {
            return n.get(0) > 1 ? n.get(0) - 1 : -1;
        }
        if (k + 1 == n.size()) {
            return n.get(k);
        }

        return n.get(k).compareTo(n.get(k + 1)) == 0 ? -1 : n.get(k);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n > 2 * 100000) {
            System.out.println(-1);
            return;
        }
        int k = sc.nextInt();
        if (k > n) {
            System.out.println(-1);
            return;
        }
        List<Integer> values = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            values.add(sc.nextInt());
        }
        System.out.println(getX(values, k - 1));
        sc.close();
    }
}
