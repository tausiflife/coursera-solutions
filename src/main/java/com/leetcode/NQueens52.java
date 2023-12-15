package com.leetcode;

public class NQueens52 {
    private int solutions;

    public static void main(String[] args) {
        NQueens52 nQueens52 = new NQueens52();
        System.out.println(nQueens52.totalNQueens(4));
    }
    public int totalNQueens(int n) {
        int[][] matrix = new int[n][n];
        matrix[0][0] = 1;
        backtrack(1, 0, 0, n, matrix);
        return solutions;
    }

    private void backtrack(int queensCount, int row, int col, int n, int[][] matrix) {
        if(queensCount == n) {
            solutions++;
            return;
        }
        for(int j=0; j<n; j++) {
            matrix[j][col] = 1;
        }
        for(int j=0; j<n; j++) {
            matrix[row][j] = 1;
        }
        int currRow = row + 1, currCol = col + 1;
        while(currRow <n && currCol < n) {
            matrix[currRow][currCol] = 1;
            currRow++;
            currCol++;
        }
        currRow = row + 1; currCol = col - 1;
        while(currRow <n && currCol > 0) {
            matrix[currRow][currCol] = 1;
            currRow++;
            currCol--;
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][j] = 1;
                    backtrack(queensCount + 1, i, j, n, matrix);
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j=0; j<n; j++) {
            matrix[j][col] = 0;
        }
        for(int j=0; j<n; j++) {
            matrix[row][j] = 0;
        }
        currRow = row + 1; currCol = col + 1;
        while(currRow <n && currCol < n) {
            matrix[currRow][currCol] = 0;
            currRow++;
            currCol++;
        }
        currRow = row + 1; currCol = col + 1;
        while(currRow <n && currCol > 0) {
            matrix[currRow][currCol] = 0;
            currRow++;
            currCol--;
        }
    }
}
