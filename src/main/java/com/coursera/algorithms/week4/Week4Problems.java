package com.coursera.algorithms.week4;

import edu.princeton.cs.algs4.MinPQ;

import java.math.BigInteger;
import java.util.Objects;


public class Week4Problems {

    /**
     * Computational number theory. Write a program CubeSum.java that prints out
     * all integers of the form a3 + b3 where a and b are integers between 0 and N in sorted
     * order, without using excessive space. That is, instead of computing an array of the N2
     * sums and sorting them, build a minimum-oriented priority queue, initially containing
     * (03, 0, 0), (13, 1, 0), (23, 2, 0), . . . , (N3, N, 0). Then, while the priority queue is nonempty,
     * remove the smallest item(i3 + j3, i, j), print it, and then, if j < N, insert the item (i3 + (j+1)3,
     * i, j+1). Use this program to find all distinct mintegers a, b, c, and d between 0 and 106
     * such that a3 + b3 = c3 + d3.
     */
    public void taxiCabNumber(int n) {
        MinPQ<CubeHolder> priorityQueue = new MinPQ<>(n + 1);
        initPriorityQueue(priorityQueue, n);
        computeTaxiCabNumbers(priorityQueue, n);
    }

    private void computeTaxiCabNumbers(MinPQ<CubeHolder> priorityQueue, int n) {
        while (!priorityQueue.isEmpty()) {
            CubeHolder minCube = priorityQueue.delMin();
            insertCubeWithJPLus1(priorityQueue, minCube, n);
            CubeHolder peek = priorityQueue.min();
            if (minCube.equals(peek)) {
                priorityQueue.delMin();
                insertCubeWithJPLus1(priorityQueue, peek, n);
                if (minCube.i != minCube.j
                        && minCube.i != peek.i
                        && minCube.i != peek.j
                        && minCube.j != peek.i
                        && minCube.j != peek.j
                        && peek.i != peek.j) {
                    System.out.println("Value 1 : " + minCube.toString());
                    System.out.println("Value 2 : " + peek.toString());
                }
            }
        }
    }

    private void insertCubeWithJPLus1(MinPQ<CubeHolder> priorityQueue, CubeHolder min, int n) {
        if (min.j > n)
            return;
        BigInteger a = BigInteger.valueOf(min.i);
        BigInteger b = BigInteger.valueOf(min.j + 1);
        BigInteger v = a.multiply(a).multiply(a).add(b.multiply(b).multiply(b));
        priorityQueue.insert(new CubeHolder(v, min.i, min.j + 1));
    }

    private void initPriorityQueue(MinPQ<CubeHolder> priorityQueue, int n) {
        for (int i = 0; i <= n; i++) {
            BigInteger a = BigInteger.valueOf(i);
            BigInteger v = a.multiply(a).multiply(a);
            priorityQueue.insert(new CubeHolder(v, i, 0));
        }
    }

    class CubeHolder implements Comparable {
        BigInteger value;
        int i;
        int j;

        public CubeHolder(BigInteger value, int i, int j) {
            this.value = value;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Object o) {
            CubeHolder that = (CubeHolder) o;
            return this.value.compareTo(that.value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CubeHolder that = (CubeHolder) o;
            return value.equals(that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "CubeHolder{" +
                    "value=" + value +
                    ", i=" + i +
                    ", j=" + j +
                    '}';
        }
    }


    public int checkCompressed(String s, String t) {
        char[] tChars = t.toCharArray();
        int sLength = 0;
        int i = 0;
        while (i < t.length()) {
            char tChar = tChars[i];
            if (Character.isAlphabetic(tChar)) {
                if (tChar != s.charAt(sLength))
                    return 0;
                ++sLength;
                i++;
            } else {
                StringBuilder builder = new StringBuilder();
                while (i < t.length() && Character.isDigit(tChars[i])) {
                    builder.append(tChars[i]);
                    ++i;
                }
                long count = Long.valueOf(builder.toString());
                sLength += count;
                if (sLength > s.length())
                    return 0;
            }
        }
        if (sLength != s.length())
            return 0;
        return 1;
    }

}
