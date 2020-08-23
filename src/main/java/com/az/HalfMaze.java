package com.az;

import java.util.Scanner;

public class HalfMaze {

    /*static int findPaths(int[][] carpaths, int N, int r, int c, int possiblePaths) {
        if(r<0 || r>=N || c<0||c>=N ||c>r) {
            return possiblePaths;
        }

        if(r==N-1 && c==N-1) {
            possiblePaths++;
            return possiblePaths;
        }

        possiblePaths=findPaths(carpaths, N, r+1,c,possiblePaths);
        possiblePaths=findPaths(carpaths, N, r,c+1,possiblePaths);


        return possiblePaths;
    }

    static int numOfPathsToDest(int n) {
        int[][] plane = new int[n][n];
        int possiblePaths= findPaths(plane, n, 0,0,0);
        return possiblePaths;
    }*/

    static int findPaths(int[][] carpaths, int N, int r, int c, int possiblePaths,int currentPathLength) {
        if(r<0 || r>=N || c<0||c>=N || c>r) {
            return currentPathLength;
        }

        if(r==N-1 && c==N-1) {
            System.out.println(currentPathLength);
            possiblePaths++;
            return possiblePaths;
        }

        if(carpaths[r][c]==1 ) {
            return currentPathLength;
        }

        carpaths[r][c]=1;
        currentPathLength+=1;

        findPaths(carpaths, N, r+1,c,possiblePaths,currentPathLength);
        findPaths(carpaths, N, r,c+1,possiblePaths,currentPathLength);

        carpaths[r][c]=0;

        return possiblePaths;
    }

    static int numOfPathsToDest(int n) {
        int[][] plane = new int[n][n];
        int possiblePaths= findPaths(plane, n, 0,0,0,0);
        return possiblePaths;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int N= sc.nextInt();
            System.out.println(numOfPathsToDest(N));}
    }
}
