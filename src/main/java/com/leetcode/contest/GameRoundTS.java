package com.leetcode.contest;

public class GameRoundTS {
    public static void main(String[] args) {
        System.out.println(numberOfRounds("12:01", "12:44"));
    }

    public static int numberOfRounds(String startTime, String finishTime) {
        int startHH = Integer.parseInt(startTime.substring(0, 2));
        int startMM = Integer.parseInt(startTime.substring(3));
        int finishHH = Integer.parseInt(finishTime.substring(0, 2));
        int finishMM = Integer.parseInt(finishTime.substring(3));

        int start = startHH * 60 + startMM;
        int end = finishHH * 60 + finishMM;
        if (start > end) {
            end += 24 * 60;
        }

        return (int) Math.floor(end / 15.00) - (int) Math.ceil(start / 15.00);
    }
}
