package com.leetcode.contest;

import java.util.*;

public class BuySellOrders {

    public static void main(String[] args) {
        //int[][] orders = new int[][]{{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}};
        //System.out.println(getNumberOfBacklogOrders(orders));

        int[][] orders2 = new int[][]{{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}};
        System.out.println(getNumberOfBacklogOrders(orders2));
    }

    public static int getNumberOfBacklogOrders(int[][] orders) {

        Comparator<int[]> comparator = Comparator.comparingInt(a -> a[0]);
        PriorityQueue<int[]> buyPriority = new PriorityQueue<>(comparator.reversed());
        PriorityQueue<int[]> sellPriority = new PriorityQueue<>(comparator);

        Arrays.stream(orders)
                .forEach(order -> {
                    if (order[2] == 1) {
                        sellPriority.offer(order);
                    } else if (order[2] == 0) {
                        buyPriority.offer(order);
                    }
                });

        //buy -[30,4,0]], [[10,5,0],
        //sell - [15,2,1],[25,1,1]
        while (!buyPriority.isEmpty()) {
            int[] buyOrder = buyPriority.peek();
            if (sellPriority.peek() != null && sellPriority.peek()[0] > buyOrder[0]) {
                break;
            }
            while (!sellPriority.isEmpty() && buyOrder[1] > 0) {
                int[] sellOrder = sellPriority.peek();

                if (buyOrder[0] >= sellOrder[0]) {
                    if (buyOrder[1] <= sellOrder[1]) {
                        buyPriority.remove(buyOrder);
                        sellOrder[1] -= buyOrder[1];
                        buyOrder[1] = 0;
                    } else {
                        sellPriority.remove(sellOrder);
                        buyOrder[1] -= sellOrder[1];
                        sellOrder[1] = 0;
                    }
                } else {
                    break;
                }
            }
        }
        int numOfOrder = 0;
        if (!buyPriority.isEmpty()) {
            Iterator iterator = buyPriority.iterator();

            while (iterator.hasNext()) {
                int[] item = (int[]) iterator.next();
                numOfOrder += item[1];
            }

        }
        if (!sellPriority.isEmpty()) {
            Iterator iterator = sellPriority.iterator();

            while (iterator.hasNext()) {
                int[] item = (int[]) iterator.next();
                numOfOrder += item[1];
            }
        }
        System.out.println(numOfOrder);
        return numOfOrder % 1000000007;
    }
}
