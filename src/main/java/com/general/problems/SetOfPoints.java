package com.general.problems;

import java.util.Arrays;

/**
 * Given a set of points on the horizontal axis of a co-ordinate plane
 * if a point is plotted in between any set, that set is reduced to that point. Given x sets
 * find minimum of of points one should pick to reduce all the points to minimum no of points
 * Given x and 2-d array
 */
public class SetOfPoints {

    public int findMinimumNumberOfPoints(int size, int[][] coordinates) {
        Arrays.sort(coordinates, (a, b) -> a[0] == b[0] ? 0 : (a[0] < b[0] ? -1 : 1));
        int ending = coordinates[0][1];
        int count = 1;
        for (int i = 1; i < coordinates.length; i++) {
            if (coordinates[i][0] <= ending)
                continue;
            else {
                ending = coordinates[i][1];
                count++;
            }
        }
        return count;
    }
}
