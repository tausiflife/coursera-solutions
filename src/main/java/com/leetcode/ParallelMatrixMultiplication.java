package com.leetcode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Parallel Matrix Multiplication: 2 matrix
 * Write a program that performs matrix multiplication in parallel using multithreading.
 * Experiment with different strategies for dividing the work among threads.
 */
public class ParallelMatrixMultiplication {
    private static int[][] generateRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] matrixA = generateRandomMatrix(4,4);
        int[][] matrixB = generateRandomMatrix(4,4);
        int[][] matrixC = new int[4][4];
        Lock lock = new ReentrantLock(true);
        Runnable run1= () -> {
            for (int i =0; i<2; i++) {
                for (int j =0; j< 2; j++) {
                    matrixC[i][j] = matrixA[i][j] * matrixB[i][j];
                }
            }
        };
        Runnable run2= () -> {
            for (int i =2; i<4; i++) {
                for (int j =2; j< 4; j++) {
                    matrixC[i][j] = matrixA[i][j] * matrixB[i][j];
                }
            }
        };
        Thread t1= new Thread(run1);
        Thread t2= new Thread(run2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        printMatrix(matrixA);
        printMatrix(matrixB);
        printMatrix(matrixC);
    }
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
