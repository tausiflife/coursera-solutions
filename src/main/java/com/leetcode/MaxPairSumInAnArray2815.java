package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxPairSumInAnArray2815 {

    public int maxSum(int[] nums) {
        int max = -1;
        Map<Integer, Integer> map = new HashMap<>(); //Map to store max digit and its number
        for(int i =0; i < nums.length; i++) {
            int largestDigit = findLargestDigit(nums[i]) ;
            Integer storedMaxNumForDigit = map.get(largestDigit);
            if(storedMaxNumForDigit == null) {
                //add if the digit doesn't exist
                map.put(largestDigit, nums[i]);
            } else {
                //if digit exists, then assign max if sum is greater than max
                max = Math.max(max, storedMaxNumForDigit + nums[i]);
                //again put the largest of the numbers for that digit to get the max
                map.put(largestDigit, Math.max(storedMaxNumForDigit, nums[i]));
            }
        }
        return max;
    }

    private boolean isLargestDigitCommon(int num1, int num2) {
        return findLargestDigit(num1) == findLargestDigit(num2);
    }

    private int findLargestDigit(int num) {
        int max = 0;
        while(num > 0){
            int d = num % 10;
            max = Math.max(max, d);
            num = num / 10;
        }
        return max;
    }
}
