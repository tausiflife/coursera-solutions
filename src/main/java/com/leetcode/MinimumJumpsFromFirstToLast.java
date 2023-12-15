package com.leetcode;

import java.util.Arrays;

public class MinimumJumpsFromFirstToLast {

    public static void main(String[] args) {
        MinimumJumpsFromFirstToLast minimumJumpsFromFirstToLast = new MinimumJumpsFromFirstToLast();
        minimumJumpsFromFirstToLast.minimumJumps(new char[]{'a','b','c','d','e','f','g'});
    }
    public int minimumJumps(char[] alphabets) {
        int[] dp = new int[alphabets.length];
        Arrays.fill(dp, -1);
        dp[alphabets.length - 1] = 0;
        minimumJumps(alphabets, 0, dp);
        return dp[0];
    }

    private int minimumJumps(char[] alphabets, int position, int[] dp) {
        if(position == alphabets.length - 1)
            return 0;
        if(dp[position] != -1)
            return dp[position];
        int minSteps =0;
        if(position + 2 <= alphabets.length - 1) {
            minSteps = Math.min(minimumJumps(alphabets, position + 1, dp)
                    ,minimumJumps(alphabets, position + 2, dp)) + 1;
        } else {
           minSteps = minimumJumps(alphabets, position + 1, dp) + 1;
        }
        dp[position] = minSteps;
        return minSteps;
    }
}
