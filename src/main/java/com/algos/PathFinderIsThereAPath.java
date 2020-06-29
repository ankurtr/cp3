package com.algos;

public class PathFinderIsThereAPath {
    public static void main(String[] args) {
        int[][] maze = {{1, 1, 0}, {1, 1, 0}, {0, 1, 1}};
        int[][] path = new int[10][10];

        System.out.println(findPath(maze, path, 3, 0, 0));
    }

    static boolean findPath(int[][] maze, int[][] path, int n, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }
        if (x == n - 1 && y == n - 1) {
            path[x][y] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(path[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }
        if (maze[x][y] == 0 || path[x][y] == 1) {
            return false;
        }

        path[x][y] = 1;

        if (findPath(maze, path, n, x, y + 1)) {
            path[x][y] = 0;
            return true;
        }
        if (findPath(maze, path, n, x, y - 1)) {
            path[x][y] = 0;
            return true;
        }
        if (findPath(maze, path, n, x + 1, y)) {
            path[x][y] = 0;
            return true;
        }
        if (findPath(maze, path, n, x - 1, y + 1)) {
            path[x][y] = 0;
            return true;
        }
        path[x][y] = 0;
        return false;
    }
}
