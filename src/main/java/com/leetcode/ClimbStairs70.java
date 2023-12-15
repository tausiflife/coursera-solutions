package com.leetcode;

public class ClimbStairs70 {
    public static void main(String[] args) {
        char c = 'c';
        int a  = (int)c;
        System.out.println("c." + 'b');
        int[] memo = new int[6];
        System.out.println(climbStairs(5, 5, memo));
    }

    private static int climbStairs(int s, int n, int[] memo) {
        if(s == 0)
            return 1;
        if(s < 0)
            return 0;
        if(memo[s] != 0)
            return memo[s];
        memo[s] = climbStairs(s-1, n, memo) + climbStairs(s-2, n , memo);
        return memo[s];
    }
}
