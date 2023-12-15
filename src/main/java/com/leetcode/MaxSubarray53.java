package com.leetcode;

public class MaxSubarray53 {
    public static void main(String[] args) {
        MaxSubarray53 maxSubarray53 = new MaxSubarray53();
        maxSubarray53.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
    public int maxSubArray(int[] nums) {
        int currentSubArraySum = nums[0];
        int max_sum = nums[0];
        int start = 0, end = 0, length = 0;
        for(int i=1; i< nums.length; i++) {
            if(currentSubArraySum + nums[i] > nums[i]) {
                currentSubArraySum = currentSubArraySum + nums[i];
                end++;
            } else {
                currentSubArraySum = nums[i];
                start = i;
                end = start;
            }
            if(currentSubArraySum > max_sum) {
                max_sum = currentSubArraySum;
                length = Math.max(length, end- start +1);
            }
        }
        return length;
    }
}
