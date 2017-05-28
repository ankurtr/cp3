package com.di.sd17;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ankur on 20/5/17.
 */
public class CobraTemple {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int N;
        int[] H;

        while (S-- > 0) {
            N = sc.nextInt();
            int n = N;
            H = new int[n];
            int x = 0;
            while (n-- > 0) {
                H[x++] = sc.nextInt();
            }
            System.out.println(buildTemple(H) == true ? "yes" : "no");
        }

    }

    public static boolean buildTemple(int[] H) {
        int N = H.length;
        if (N % 2 == 0)
            return false;
        int Ni = 1;
        boolean valid = true;
        for (int i = 0, j = N - 1; i <= N / 2 && j >= N / 2; i++, j--) {
            if (i == j && H[i] != Ni)
                valid = false;
            if (H[i] == Ni && H[j] == Ni) {
                Ni += 1;
                continue;
            } else {
                valid = false;
                break;
            }
        }
        return valid;
    }

    public static boolean buildTemple1(int[] H) {
        int N = H.length;
        if (N % 2 == 0 || H[0] != 1 || H[N - 1] != 1)
            return false;
        for (int i = 0; i < (N / 2); i++) {
            if (H[i + 1] - H[i] != 1)
                return false;
        }
        for (int i = N / 2; i < N - 1; i++) {
            if (H[i] - H[i + 1] != 1)
                return false;
        }
        return true;
    }

    public static int checkTemple(int[] H) {
        int N = H.length;
        int expectedValue = 1;
        int operations = 0;
        if (N % 2 == 0) {
            int[] newH1 = Arrays.copyOfRange(H, 1, H.length);
            int[] newH2 = Arrays.copyOfRange(H, 0, H.length - 1);
            return Math.min(checkTemple(newH1) + 1, checkTemple(newH2) + 1);
        }
        for (int i = 0, j = N - 1; i <= N / 2 && j >= N / 2; i++, j--) {
            if (H[i] == expectedValue && H[j] == expectedValue) {
                expectedValue++;
                continue;
            } else {
                if (i != j) {
                    operations += Math.abs(H[i] - expectedValue);
                    operations += Math.abs(H[j] - expectedValue);
                } else {
                    operations += Math.abs(H[j] - expectedValue);
                }
            }
            expectedValue++;
        }
        return operations;
    }
}

