package com.az;

import java.util.*;

public class TreeCut {

    public static void main(String[] args) {
        List<List<Integer>> forest = new ArrayList<>();
        List<Integer> list1 = new ArrayList();
        list1.add(2);
        list1.add(2);
        list1.add(3);
        forest.add(list1);

        List<Integer> list2 = new ArrayList();
        list2.add(0);
        list2.add(0);
        list2.add(2);
        forest.add(list2);

        List<Integer> list3 = new ArrayList();
        list3.add(7);
        list3.add(6);
        list3.add(5);
        forest.add(list3);

        System.out.println(new TreeCut().cutOffTree(forest));
    }

    public int cutOffTree(List<List<Integer>> forest) {
        int[][] a = new int[forest.size()][forest.get(0).size()];
        for (int i = 0; i < forest.size(); i++)
            for (int j = 0; j < forest.get(0).size(); j++)
                a[i][j] = forest.get(i).get(j);

        List<Integer> l = new ArrayList<Integer>();
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != 0) l.add(a[i][j]);
                map.put(a[i][j], new int[]{i, j});
            }
        Collections.sort(l);

        int ret = 0;
        int[] cur = new int[]{0, 0};
        for (int i : l) {
            int tmp = getStep(a, cur, map.get(i));
            if (tmp == -1) return -1;
            ret += tmp;
            cur = map.get(i);
        }
        return ret;
    }

    private int getStep(int[][] a, int[] cur, int[] end) {
        boolean[][] m = new boolean[a.length][a[0].length];
        int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int step = 0;
        boolean f = false;
        Queue<int[]> q = new LinkedList<int[]>();
        Queue<int[]> qq = new LinkedList<int[]>();
        q.add(cur);
        while (!q.isEmpty()) {
            int[] t = q.remove();
            if (t[0] == end[0] && t[1] == end[1]) {
                f = true;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int x = t[0] + d[i][0], y = t[1] + d[i][1];
                if (x < 0 || y < 0 || x >= a.length || y >= a[0].length || a[x][y] == 0 || m[x][y]) continue;
                qq.add(new int[]{x, y});
                m[x][y] = true;
            }

            if (q.isEmpty()) {
                q = qq;
                qq = new LinkedList<int[]>();
                step++;
            }
        }

        return f ? step : -1;
    }


   /* public int cutOffTree(List<List<Integer>> forest) {
        int[][] maze = new int[forest.size()][forest.get(0).size()];
        int nonZeroCnt = 0;
        for (int i = 0; i < forest.size(); i++) {
            List<Integer> currentForest = forest.get(i);
            for (int j = 0; j < forest.get(i).size(); j++) {
                maze[i][j] = currentForest.get(j);
                if (!(i==0&&j==0) && maze[i][j] > 1) {
                    nonZeroCnt++;
                }
            }
        }

        int[][] mazeX = {{7},{0},{3299},{3212},{8228},{0},{1320}};

        int trees = solveMaze(mazeX, 0, 0, maze.length, 0);

        if (trees < nonZeroCnt) {
            return -1;
        } else {
            return trees;
        }
    }

    private int solveMaze(int[][] maze, int x, int y, int N, int trees) {
        if (x < 0 || x > N - 1 || y < 0 || y > N - 1) {
            return trees;
        }
        if (maze[x][y] == 0) {
            return trees;
        }

        if (maze[x][y] > 1) {
            if(!(x==0 && y==0)) {
                trees++;

                maze[x][y] = 0;
            }

        }

        int t1 = solveMaze(maze, x, y + 1, N, trees);
        int t2 = solveMaze(maze, x, y - 1, N, trees);
        int t3 = solveMaze(maze, x + 1, y, N, trees);
        int t4 = solveMaze(maze, x - 1, y + 1, N, trees);

        trees = Math.max(trees, t1);
        trees = Math.max(trees, t2);
        trees = Math.max(trees, t3);
        trees = Math.max(trees, t4);
        return trees;

    }*/
}