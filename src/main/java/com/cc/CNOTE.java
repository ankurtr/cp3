package com.cc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by trapaank1 on 26/02/19.
 */
public class CNOTE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input1 = br.readLine().split(" ");
            int X = Integer.parseInt(input1[0]);
            int Y = Integer.parseInt(input1[1]);
            int K = Integer.parseInt(input1[2]);
            int N = Integer.parseInt(input1[3]);
            boolean found = false;

            for (int i = 0; i < N; i++) {
                String[] input2 = br.readLine().split(" ");
                int pages = Integer.parseInt(input2[0]);
                int price = Integer.parseInt(input2[1]);
                if (price <= K && (X - Y) <= pages)
                    found = true;
            }
            if (!found) {
                System.out.println("UnluckyChef");
            } else {
                System.out.println("LuckyChef");
            }
        }
    }
}
