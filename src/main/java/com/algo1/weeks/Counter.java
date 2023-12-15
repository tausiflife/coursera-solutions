package com.algo1.weeks;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Counter {

    public static int countCommonPoints(Point2D[] a, Point2D[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int aIdx = 0, bIdx = 0, count = 0;
        while (aIdx < a.length && bIdx < b.length) {
            int result = a[aIdx].compareTo(b[bIdx]);
            if (result == 0) {
                aIdx++; bIdx++; count++;
            } else if (result < 0)
                aIdx++;
            else
                bIdx++;
        }
        return count;
    }

    public static void main(String[] args) {
        Point2D[] a = new Point2D[5];
        Point2D[] b = new Point2D[5];
        for (int i = 0; i < 5; i++) {
            int x1 = StdRandom.uniform(2);
            int y1 = StdRandom.uniform(2);
            a[i] = new Point2D(x1, y1);
            int x2 = StdRandom.uniform(2);
            int y2 = StdRandom.uniform(2);
            b[i] = new Point2D(x2, y2);
        }
        countCommonPoints(a,b);
    }
}
