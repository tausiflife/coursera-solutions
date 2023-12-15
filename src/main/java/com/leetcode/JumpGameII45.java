package com.leetcode;

import java.util.Arrays;

public class JumpGameII45 {
    public static void main(String[] args) {
        JumpGameII45 jumpGameII45 = new JumpGameII45();
        System.out.println(jumpGameII45.jump(new int[]{2,3,0,1,4}));
    }
    private int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[dp.length - 1] = 0;
        return calculateSteps(0, nums, dp);
    }

    private int calculateSteps(int position, int[] nums, int[] dp) {
        if(position >= nums.length - 1)
            return 0;
        if(dp[position] != -1)
            return dp[position];
        int furthestStep = Math.min(position + nums[position], nums.length -1);
        int minStep = 9999;
        for(int step=position + 1; step <=furthestStep; step++) {
            minStep = Math.min(minStep, calculateSteps(step, nums, dp)+1);
        }
        dp[position] = minStep;
        return minStep;
    }
}
