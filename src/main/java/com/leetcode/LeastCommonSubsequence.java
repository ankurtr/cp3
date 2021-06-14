package com.leetcode;

//https://leetcode.com/problems/delete-operation-for-two-strings/solution/
public class LeastCommonSubsequence {

    public static void main(String[] args) {
        //System.out.println(lcs("ABCD", "BAEC"));
        //System.out.println(lcsm("ABCD", "BAEC", 4, 4, new int[5][5]));

        System.out.println(lcsm("ABCD", "BAEC", 4, 4, new int[5][5]));
    }

    private static int lcs(String s1, String s2) {
        return s1.length() + s2.length() - 2 * lcs(s1, s2, s1.length(), s2.length());
    }

    private static int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcs(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
        }
    }

    private static int lcsm(String s1, String s2, int m, int n, int[][] mem) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (mem[m][n] > 0) {
            return mem[m][n];
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            mem[m][n] = 1 + lcsm(s1, s2, m - 1, n - 1, mem);
        } else {
            mem[m][n] = Math.max(lcsm(s1, s2, m - 1, n, mem), lcsm(s1, s2, m, n - 1, mem));
        }
        return mem[m][n];
    }

    private static int lcsm2(String s1, String s2, int m, int n, int[][] mem) {
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    mem[i][j] = 0;
                }
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    mem[i][j] = 1 + mem[i - 1][j - 1];
                } else {
                    mem[i][j] = Math.max(mem[i - 1][j], mem[i][j - 1]);
                }
            }
        }
        return mem[m][n];
    }
}
