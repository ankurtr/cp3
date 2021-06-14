package com.leetcode.contest;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PointsInsideCircle {

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        int[][] queries = {{1, 2, 2}, {2, 2, 2}, {4, 3, 2}, {4, 3, 3}};
        int[] result = countPoints(points, queries);
        IntStream.range(0, result.length)
                .forEach(idx -> System.out.println(result[idx]));
    }

    private static int[] countPoints(int[][] points, int[][] queries) {
        if (points == null || queries == null) {
            return new int[0];
        }

        int[] result = new int[queries.length];
        IntStream.range(0, queries.length)
                .forEach(index -> {
                    int[] query = queries[index];
                    int x0 = query[0];
                    int y0 = query[1];
                    int r = query[2];
                    result[index] = 0;
                    Arrays.stream(points).forEach(
                            point -> {
                                int x1 = point[0];
                                int y1 = point[1];

                                double distanceX = Math.pow((x1 - x0), 2);
                                double distanceY = Math.pow((y1 - y0), 2);

                                double distance = Math.sqrt(distanceX + distanceY);

                                if (distance <= r) {
                                    result[index]++;
                                }
                            }
                    );
                });

        return result;
    }
}
