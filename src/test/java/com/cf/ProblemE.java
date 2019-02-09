package com.cf;

import java.util.ArrayList;
import java.util.Scanner;

public class ProblemE {

    ArrayList<Integer> a[];
    boolean u[];

    public static void main(String[] args) {
        new ProblemE().solve();

    }

    boolean dfs(int s, boolean result) {
        u[s] = true;
        //System.out.println(s);

        if (a[s].size() >= 3 || a[s].size() <= 1)
            result = false;

        for (int i : a[s]) {
            if (!u[i]) {
                boolean f = dfs(i, result);
                if (!f)
                    result = false;
            }
        }

        return result;
    }

    void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        a = new ArrayList[n + 1];
        u = new boolean[n + 1];

        for (int i = 1; i <= n; i++)
            a[i] = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            a[u].add(v);
            a[v].add(u);
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (!u[i]) {
                if (dfs(i, true))
                    count++;
            }
        }

        System.out.println(count);
    }

}