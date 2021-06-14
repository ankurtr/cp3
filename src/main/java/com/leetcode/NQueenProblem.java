package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NQueenProblem {
    private int size;
    private List<List<String>> solutions = new ArrayList<>();

    public static void main(String[] args) {

    }

    public List<List<String>> solveNQueens(int n) {
        size = n;
        char[][] emptyBoard = new char[size][size];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                emptyBoard[i][j] = '.';
            }
        }
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), emptyBoard);
        return solutions;
    }

    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<>();
        for (int row = 0; row < size; row++) {
            String current_row = new String(state[row]);
            board.add(current_row);
        }
        return board;
    }

    private void backtrack(int row, HashSet<Integer> cols, HashSet<Integer> diagonals, HashSet<Integer> antiDiagonals,
                           char[][] state) {
        if (row == size) {
            solutions.add(createBoard(state));
            return;
        }

        for (int col = 0; col < size; col++) {
            int currentDiagonal = row - col;
            int currentAntiDiagonal = row + col;

            if (cols.contains(col) || diagonals.contains(currentDiagonal) ||
                    antiDiagonals.contains(currentAntiDiagonal)) {
                continue;
            }

            state[row][col] = 'Q';
            cols.add(col);
            diagonals.add(row - col);
            antiDiagonals.add(row + col);

            backtrack(row + 1, cols, diagonals, antiDiagonals, state);

            cols.remove(col);
            diagonals.remove(currentDiagonal);
            antiDiagonals.remove(currentAntiDiagonal);
            state[row][col] = '.';
        }
    }
}
