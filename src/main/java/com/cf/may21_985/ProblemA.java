package com.cf.may21_985;


import java.util.Scanner;
import java.util.stream.IntStream;


/**
 * Created by trapaank1 on 21/05/18.
 */
public class ProblemA {

    public static int calculateMaxMoves(boolean[] positions) {

        long white = IntStream.range(0, positions.length)
                .filter(value -> value % 2 != 0 && positions[value]).count();

        long black = IntStream.range(0, positions.length)
                .filter(value -> value % 2 == 0 && positions[value]).count();

        return 0;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] positions;

        while (sc.hasNext()) {
            int n = sc.nextInt();
            positions = new boolean[n];
            String str = sc.next();
            String[] occupied_positions = str.split(" ");

            for (String occupied_position : occupied_positions) {
                positions[Integer.valueOf(occupied_position)] = true;
            }
        }
    }
}
