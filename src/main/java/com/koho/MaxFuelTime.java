package com.koho;

import java.util.HashMap;

public class MaxFuelTime {

    public static void main(String[] args) {
        /*int[] A = {2, 2, 4, 3, 1};
        int X = 1;
        int Y = 5;
        int Z = 3;
        System.out.println(solution(A, X, Y, Z));*/

        System.out.println(solution(new int[]{2, 8, 4, 3, 2}, 7, 11, 3));
    }

    public static Integer solution(int[] A, int X, int Y, int Z) {
        int maxX = 0;
        int maxY = 0;
        int maxZ = 0;
        int max = 0;


        int maxM = (X >= Y ? X : Y) >= Z ? (X >= Y ? X : Y) : Z;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (true) {
            for (int i = 0; i < A.length; i++) {
                if (A[i] != 0 && A[i] <= X && max >= maxX) {
                    X -= A[i];
                    map.put(i, max);
                    maxX += A[i];
                    A[i] = 0;
                    break;
                }
            }
            for (int i = 0; i < A.length; i++) {
                if (A[i] != 0 && A[i] <= Y && max >= maxY) {
                    Y -= A[i];
                    map.put(i, max);
                    maxY += A[i];
                    A[i] = 0;
                    break;
                }
            }
            for (int i = 0; i < A.length; i++) {
                if (A[i] != 0 && A[i] <= Z && max >= maxZ) {
                    Z -= A[i];
                    map.put(i, max);
                    maxZ += A[i];
                    A[i] = 0;
                    break;
                }
            }
            max++;
            if (max > maxM) {
                break;
            }
        }
        System.out.println(map);
        if (map.size() != A.length) {
            return -1;
        } else {
            return map.get(A.length - 1);
        }
    }
}
