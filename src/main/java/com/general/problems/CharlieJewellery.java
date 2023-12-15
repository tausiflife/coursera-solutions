package com.general.problems;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Charlie has want to make a necklace with min 1 pearl and max X pearl.
 * Each pearl has a magnificence
 * Pearl should be in non-decreasing order of their magnificence.
 * Find the number of necklace that can be made
 * You are give max pearl(X), starting power of pearl and ending power of
 * pearl
 */
public class CharlieJewellery {

    /**
     * Matrix assumes matrix[i][j] = number of combinations that end with startingPower + j
     * Basically for startingPower = 6 and endingPower = 9
     * we have 4 columns representing the number of combinations that end with that number taken
     * ith pearl at a time
     *
     * We start with this as taken one pearl at max each will have one combination
     *      0(6)  1(7)  2(8)  3(9)
     * 0(1)  1     1     1     1
     * 1(2)  1     0     0     0
     * 2(3)  1     0     0     0
     *
     * Now each pearls build on previous pearl ending, i.e pearl ending with 7 taken 2 at a time,
     * sum of pearls ending with 7 taken one at a time and pearls ending with 6 taken one at a time
     * sum = matrix[i - 1][j] + matrix[i][j - 1];
     * why this works?
     *
     * lets say n = 1, taken one at a time
     * 6,7,8,9
     * lets say n = 2, taken 2 at a time
     * (6,6)
     * (6,7),(7,7)
     * (6,8),(7,8),(8,8)
     * (6,9),(7,9),(8,9),(9,9)
     *
     * lets say n = 3, taken 3 at a time
     * (6,(6,6))
     * (6,(6,7)),(6,(7,7))
     * (6,(6,8)),(6,(7,8)),(6,(8,8))
     * (6,(6,9)),(6,(7,9)),(6,(8,9)),(6,(9,9))
     * (7,(7,7))
     * (7,(7,8)),(7,(8,8))
     * (7,(7,9)),(7,(8,9)),(7,(9,9))
     * (8,(8,8))
     * (8,(8,9)),(8,(9,9))
     * (9,(9,9))
     * @param maxPearl
     * @param startingPower
     * @param endingPower
     * @return
     */
    public int calculateNumberOfNecklace(int maxPearl, int startingPower, int endingPower) {
        int diff = endingPower - startingPower + 1; // Including both range hence + 1
        int[][] matrix = new int[maxPearl][diff];
        int[] row = new int[diff];
        Arrays.fill(row, 1); // 1st row taken 1 pearl at a time
        matrix[0] = row;
        for (int i = 0; i < maxPearl; i++)
            matrix[i][0] = 1;
        int sum = diff + maxPearl - 1; //initial sum = sum or row[0] and column[0], as matrix[0][0] is common, so - 1
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
