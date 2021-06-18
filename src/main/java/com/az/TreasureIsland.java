package com.az;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {
    public static void main(String[] args) {
        //[['O', 'O', 'O', 'O'],
        // ['D', 'O', 'D', 'O'],
        // ['O', 'O', 'O', 'O'],
        // ['X', 'D', 'D', 'O']];
        char[][] island = {{'0', '0', '0', '0'}, {'D', '0', 'D', '0'}, {'0', '0', '0', '0'},
                {'X', 'D', 'D', '0'}};

        System.out.println(treasureIsland(island));
    }

    private static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int treasureIsland(char[][] island) {
        if (island == null || island.length == 0) {
            return -1;
        }

        int steps = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(0, 0));
        boolean[][] visited = new boolean[island.length][island[0].length];

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate coordinate = queue.poll();

                int x = coordinate.x;
                int y = coordinate.y;

                if (island[x][y] == 'X') return steps;

                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length &&
                            island[newX][newY] != 'D' && !visited[newX][newY]) {
                        queue.offer(new Coordinate(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
            steps++;
        }

        return steps;
    }
}
