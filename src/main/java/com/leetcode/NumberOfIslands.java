package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        numIslands(grid);
    }
    private static int[][] dirs = {{-1,0}, {0,1},{1,0},{0,-1} };
    // becuase you can only move in either horizontal or vertical direction
    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        //will store whether that location has been visited. If yes then 1 else 0
        int[][] visited = new int[rows][cols];
        int count = 0;
        for(int row = 0; row<rows;row++) {
            for(int col =0; col<cols;col++) {
                //The location is having value 1 meaning land and is not visited
                if(grid[row][col] == '1' && visited[row][col] == 0) {
                    count++;
                    bfs(grid, visited, row, col);
                }
            }
        }
        return count;
    }

    /**
     * This method uses BFS to mark the locations as visited
     * based on the condition if they are horizontally({0,1},{0,-1})
     * or vertically({-1,0},{1,0}) connected. This will help in defining
     * island
     * @param grid
     * @param visited
     * @param row
     * @param col
     */
    private static void bfs(char[][] grid, int[][] visited, int row, int col) {
        visited[row][col] = 1;
        Queue<Integer[]> queue =  new LinkedList<>();
        queue.add(new Integer[]{row, col});
        int rows = grid.length;
        int cols = grid[0].length;
        while(!queue.isEmpty()) {
            int visitedRow = queue.peek()[0];
            int visitedCol = queue.peek()[1];
            queue.remove();
            for (int[] dir : dirs) {
                int y = visitedRow + dir[0];
                int x = visitedCol + dir[1];
                if (y >= 0 && y < rows && x >= 0 && x < cols
                        && visited[y][x] == 0 && grid[y][x] == '1') {
                    visited[y][x] = 1;
                    queue.add(new Integer[]{y,x});
                }
            }
        }
    }
}
