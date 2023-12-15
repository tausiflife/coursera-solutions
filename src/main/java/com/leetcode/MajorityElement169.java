package com.leetcode;

public class MajorityElement169 {

    public int majorityElement(int[] nums) {
        int low = 0, high = nums.length- 1, left = low, right = high, p = low + (high - low) /2;

        while (true) {
            while (nums[left] < nums[p]) {
                left++;
                if (left == high)
                    break;
            }
            while (nums[right] >= nums[p]) {
                right--;
                if (right == low)
                    break;
            }

            if(left >= right)
                break;
            swap(nums, left, right);
        }
        return nums[p];
    }

    private void swap(int[] nums, int left, int right) {
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }

    public static void main(String[] args) {
        MajorityElement169 majorityElement169 = new MajorityElement169();
        majorityElement169.majorityElement(new int[]{1,2,3,4,5,6,7,8,9});
    }
}
