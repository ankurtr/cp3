package com.leetcode;

class NumOfIslands {

    boolean isSafe(char[][] grid, boolean[][] visited, int i, int j) {
        return (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length
                && !visited[i][j] && grid[i][j] == '1');
    }

    public int numIslands(char[][] grid) {
        int islands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isSafe(grid, visited, i, j)) {
                    islands += 1;
                    visitIsland(grid, visited, i, j);
                }
            }
        }
        return islands;
    }

    void visitIsland(char[][] grid, boolean[][] visited, int i, int j) {
        if (!isSafe(grid, visited, i, j)) {
            return;
        }

        visited[i][j] = true;

        visitIsland(grid, visited, i - 1, j);
        visitIsland(grid, visited, i, j - 1);
        visitIsland(grid, visited, i, j + 1);
        visitIsland(grid, visited, i + 1, j);
    }

}
