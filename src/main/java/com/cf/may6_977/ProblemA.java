package com.cf.may6_977;

import java.util.Scanner;

/**
 * Created by trapaank1 on 06/05/18.
 */
public class ProblemA {

    public static int calculateResult(int n, int k) {

        while (k-- > 0) {
            if (n % 10 == 0) {
                n /= 10;
            } else {
                n -= 1;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(calculateResult(n, k));
        }
    }
}
