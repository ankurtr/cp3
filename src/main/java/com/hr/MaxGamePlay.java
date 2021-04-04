package com.hr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxGamePlay {
    public static void main(String[] args) {
        List<Integer> inputArr = new ArrayList<>();
        /*inputArr.add(5);
        inputArr.add(2);
        inputArr.add(6);
        inputArr.add(3);
        inputArr.add(4);*/
        /*inputArr.add(3);
        inputArr.add(1);*/
        inputArr.add(1);
        inputArr.add(3);
        inputArr.add(5);
        inputArr.add(7);
        inputArr.add(9);
        System.out.println(gamingArray(inputArr));
    }

    enum Player {
        BOB, ANDY;
    }

    public static String gamingArray(List<Integer> arr) {
        Player winner = null;
        Integer[] inputArr = arr.toArray(new Integer[0]);
        int max;
        Player currentPlayer = Player.BOB;
        Integer[] newArr = inputArr;

        while (winner == null) {
            max = findMaxIndex(newArr);
            newArr = Arrays.copyOfRange(inputArr, 0, max);
            if (newArr.length > 0) {
                currentPlayer = (currentPlayer == Player.BOB ? Player.ANDY : Player.BOB);
            } else {
                winner = currentPlayer;
            }
        }
        return winner.name();
    }

    private static int findMaxIndex(Integer[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }
}
