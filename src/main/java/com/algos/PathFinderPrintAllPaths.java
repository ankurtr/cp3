package com.algos;

public class PathFinderPrintAllPaths {
    public static void main(String[] args) {
        int[][] maze = {{1, 1, 0}, {1, 1, 0}, {0, 1, 1}};
        int[][] path = new int[10][10];

        findPath(maze, path, 3, 0, 0);
    }

    static void findPath(int[][] maze, int[][] path, int n, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return;
        }
        if (x == n - 1 && y == n - 1) {
            path[x][y] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(path[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        if (maze[x][y] == 0 || path[x][y] == 1) {
            return;
        }

        path[x][y] = 1;

        findPath(maze, path, n, x, y + 1);
        findPath(maze, path, n, x, y - 1);
        findPath(maze, path, n, x + 1, y);
        findPath(maze, path, n, x - 1, y + 1);

        path[x][y]=0;
    }
}
