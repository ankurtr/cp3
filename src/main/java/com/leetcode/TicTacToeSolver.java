package com.leetcode;

//https://leetcode.com/problems/design-tic-tac-toe/
public class TicTacToeSolver {

    public static void main(String[] args) {

    }
}

class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;
    int n;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.n = n;
    }

    public int move(int row, int column, int player) {
        int value = player == 1 ? 1 : -1;
        rows[row] += value;
        cols[column] += value;

        if (row == column) {
            diagonal += value;
        }

        if (row == cols.length - column - 1) {
            antiDiagonal += value;
        }

        if ((Math.abs(rows[row]) == n) || (Math.abs(cols[column]) == n)
                || (Math.abs(diagonal) == n) || (Math.abs(antiDiagonal) == n)) {
            return player;
        }
        return 0;
    }
}