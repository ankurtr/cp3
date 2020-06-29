package com.cc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by trapaank1 on 26/02/19.
 */
public class LECANDY {
    public static String canDistributeCandy(int[] nc, int[] distrib) {
        String no = "No";
        String yes = "Yes";
        if (nc == null || distrib == null) return no;
        int candy = nc[1];
        int number = nc[0];
        if ((number > 0 && candy == 0) || (number == 0 && candy > 0)) {
            return no;
        }

        int sum = Arrays.stream(distrib).sum();

        return sum <= candy ? yes : no;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String nc = br.readLine();
            String[] ncarr = nc.split(" ");
            int[] ncarri = new int[ncarr.length];
            ncarri[0] = Integer.valueOf(ncarr[0]);
            ncarri[1] = Integer.valueOf(ncarr[1]);

            String[] distrib = br.readLine().split(" ");
            int[] distribi = new int[distrib.length];

            int i = 0;
            for (String dst : distrib) {
                distribi[i++] = Integer.valueOf(dst);
            }
            System.out.println(canDistributeCandy(ncarri, distribi));
        }
    }
}
