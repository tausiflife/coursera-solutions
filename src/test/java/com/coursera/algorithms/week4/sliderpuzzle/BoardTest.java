package com.coursera.algorithms.week4.sliderpuzzle;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BoardTest {

    @Test
    public void shouldConvertBoardToString() {
        Board board = new Board(new int[][]{{1, 0, 3}, {4, 2, 5}, {7, 8, 6}});
        String str = board.toString();
        String s = "3\n" +
                "1 0 3 \n" +
                "4 2 5 \n" +
                "7 8 6";
        Assert.assertTrue(str.equals(s));
    }

    @Test
    public void shouldTestHammingDistance() {
        Board board = new Board(new int[][]{{8, 1, 3}, {4, 0, 2}, {7, 6, 5}});
        int hamming = board.hamming();
        Assert.assertEquals(5, hamming);
    }

    @Test
    public void shouldCalculateManhattanDistance() {
        Board board = new Board(new int[][]{{8, 1, 3}, {4, 0, 2}, {7, 6, 5}});
        int hamming = board.manhattan();
        Assert.assertEquals(10, hamming);
    }

    @Test
    public void shouldCalculateNeighboursWithTopMiddleZero() {
        Board board = new Board(new int[][]{{1, 0, 3}, {4, 2, 5}, {7, 8, 6}});
        List<Board> neighbors = (List<Board>) board.neighbors();
        Assert.assertEquals(3, neighbors.size());
    }

    @Test
    public void shouldCalculateNeighboursWithTopRightZero() {
        Board board = new Board(new int[][]{{0, 1, 3}, {4, 2, 5}, {7, 8, 6}});
        List<Board> neighbors = (List<Board>) board.neighbors();
        Assert.assertEquals(2, neighbors.size());
    }

    @Test
    public void shouldCalculateNeighboursWithTopLeftZero() {
        Board board = new Board(new int[][]{{3, 1, 0}, {4, 2, 5}, {7, 8, 6}});
        List<Board> neighbors = (List<Board>) board.neighbors();
        Assert.assertEquals(2, neighbors.size());
    }

    @Test
    public void shouldCalculateNeighboursWithMiddleZero() {
        Board board = new Board(new int[][]{{3, 1, 2}, {4, 0, 5}, {7, 8, 6}});
        List<Board> neighbors = (List<Board>) board.neighbors();
        Assert.assertEquals(4, neighbors.size());
    }

    @Test
    public void shouldCalculateNeighboursWithBottomMiddleZero() {
        Board board = new Board(new int[][]{{1, 8, 3}, {4, 2, 5}, {7, 0, 6}});
        List<Board> neighbors = (List<Board>) board.neighbors();
        Assert.assertEquals(3, neighbors.size());
    }

    @Test
    public void shouldCalculateNeighboursWithBottomLeftZero() {
        Board board = new Board(new int[][]{{6, 1, 3}, {4, 2, 5}, {0, 8, 7}});
        List<Board> neighbors = (List<Board>) board.neighbors();
        Assert.assertEquals(2, neighbors.size());
    }

    @Test
    public void shouldCalculateNeighboursWithBottomRightZero() {
        Board board = new Board(new int[][]{{3, 1, 6}, {4, 2, 5}, {7, 8, 0}});
        List<Board> neighbors = (List<Board>) board.neighbors();
        Assert.assertEquals(2, neighbors.size());
    }
}
