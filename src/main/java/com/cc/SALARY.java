package com.cc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by trapaank1 on 03/03/19.
 */
public class SALARY {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] salaries = new int[N];
            int min = Integer.MAX_VALUE;
            for(int i=0;i<N;i++) {
                salaries[i] = Integer.parseInt(br.readLine());
                if (salaries[i] < min) {
                    min = salaries[i];
                }
            }
            System.out.println(calculateSteps(salaries, min));
            System.out.println("This is a test message, that should not be commited");
        }
    }

    public static int calculateSteps(int[] salaries, int min) {
        return ((Arrays.stream(salaries).sum()) - (salaries.length * min));
    }
}
