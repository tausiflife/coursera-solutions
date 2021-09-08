package com.coursera.algorithms.week4.sliderpuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private int[][] tiles;
    private int n;
    private int[][] goalBoard;

    public Board(int[][] tiles) {
        this.tiles = tiles;
        this.n = tiles.length;
//        populateGoalBoard();
    }

    // string representation of this board
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(n).append("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                builder.append(tiles[i][j]).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString().trim();
    }

    // board dimension n
    public int dimension() {
        return n;
    }

    // number of tiles out of place
    public int hamming() {
        int countOutOfPlace = 0;
        int number = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i != n - 1 && j != n - 1 && tiles[i][j] == 0)) {
                    ++number;
                    continue;
                }
                if ((i == n - 1 && j == n - 1 && tiles[i][j] != 0)
                        || tiles[i][j] != number++) {
                    ++countOutOfPlace;
                }
            }
        }
        return countOutOfPlace;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int manhattanDistance = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tile = tiles[i][j];
                if (tile == 0)
                    continue;
                int finalPosition = tile - 1; //zero based
                int finalRow = getRow(finalPosition);
                int finalColumn = getColumn(finalPosition);
                manhattanDistance += calculateDistance(finalRow, finalColumn, i, j);
            }
        }
        return manhattanDistance;
    }

    private int calculateDistance(int finalRow, int finalColumn, int currentRow, int currentColumn) {
        return Math.abs(finalRow - currentRow) + Math.abs(finalColumn - currentColumn);
    }

    private int getColumn(int finalPosition) {
        return finalPosition % n;
    }

    private int getRow(int finalPosition) {
        return finalPosition / n;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return false;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (!(y instanceof Board))
            return false;
        Board otherBoard = (Board) y;
        if (otherBoard.tiles.length != n)
            return false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] != otherBoard.tiles[i][j])
                    return false;
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        int zeroRow = 0, zeroColumn = 0;
        boolean zeroFound = false;
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (tiles[row][column] == 0) {
                    zeroFound = true;
                    zeroRow = row;
                    zeroColumn = column;
                    break;
                }
            }
            if (zeroFound)
                break;
        }
        List<Board> boardList = new ArrayList<>();
        if (hasBackwardNeighbour(zeroRow)) {
            int[][] copy = getCopyOfTiles();
            swap(copy, zeroRow - 1, zeroColumn, zeroRow, zeroColumn);
            boardList.add(new Board(copy));
        }
        if (hasForwardNeighbour(zeroRow)) {
            int[][] copy = getCopyOfTiles();
            swap(copy, zeroRow + 1, zeroColumn, zeroRow, zeroColumn);
            boardList.add(new Board(copy));
        }
        if (hasBackwardNeighbour(zeroColumn)) {
            int[][] copy = getCopyOfTiles();
            swap(copy, zeroRow, zeroColumn - 1, zeroRow, zeroColumn);
            boardList.add(new Board(copy));
        }

        if (hasForwardNeighbour(zeroColumn)) {
            int[][] copy = getCopyOfTiles();
            swap(copy, zeroRow, zeroColumn + 1, zeroRow, zeroColumn);
            boardList.add(new Board(copy));
        }
        return boardList;
    }

    private int[][] getCopyOfTiles() {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(tiles[i], tiles[i].length);
        }
        return copy;
    }

    private boolean hasForwardNeighbour(int row) {
        return row + 1 < n;
    }

    private boolean hasBackwardNeighbour(int row) {
        return row - 1 >= 0;
    }

    private void swap(int[][] arr, int row1, int col1, int row2, int col2) {
        int tmp = arr[row1][col1];
        arr[row1][col1] = arr[row2][col2];
        arr[row2][col2] = tmp;
    }

    private int getPosition(int value) {
        int postition = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] == 0)
                    return postition;
                else
                    ++postition;
            }
        }
        return postition;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        return null;
    }

    // unit testing (not graded)
    public static void main(String[] args) {

    }
}
