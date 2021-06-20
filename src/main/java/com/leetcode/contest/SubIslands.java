package com.leetcode.contest;

public class SubIslands {

    public static void main(String[] args) {
        int[][] A = {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] B = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};

        System.out.println(countSubIslands(A, B));
    }

    /*private static boolean isSafe(int r, int c, int[][] B) {
        if (r < 0 || r > B.length - 1 || c < 0 || c > B[0].length - 1 || B[r][c] == 0) {
            return true;
        }
        return false;
    }

    private static int countSubIslands(int[][] A, int[][] B) {
        int count = 0;
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                if (B[r][c] == 1 && checkIsland(B, A, r, c)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean checkIsland(int[][] B, int[][] A, int r, int c) {
        if (isSafe(r, c, B)) return true;
        B[r][c] = 0;

        return checkIsland(B, A, r + 1, c)
                & checkIsland(B, A, r, c + 1)
                & checkIsland(B, A, r - 1, c)
                & checkIsland(B, A, r, c - 1)
                & A[r][c] == 1;
    }*/

    public static int countSubIslands(int[][] B, int[][] A) {
        int m = A.length, n = A[0].length, res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (A[i][j] == 1)
                    res += dfs(B, A, i, j);
        return res;
    }


    private static int dfs(int[][] B, int[][] A, int i, int j) {
        int m = A.length, n = A[0].length, res = 1;
        if (i < 0 || i == m || j < 0 || j == n || A[i][j] == 0) return 1;
        A[i][j] = 0;
        res &= dfs(B, A, i - 1, j);
        res &= dfs(B, A, i + 1, j);
        res &= dfs(B, A, i, j - 1);
        res &= dfs(B, A, i, j + 1);
        return res & B[i][j];
    }
}
