package com.general.problems;

public class CheckMinHeap {

    /**
     * Design a linear-time certification algorithm to check whether an array pq[] is
     *     a min-oriented heap.
     * @param arr
     * @return
     */
    public boolean isMinHeap(int[] arr) {
        int root = Integer.MAX_VALUE;
        if (arr == null || arr.length < 1)
            return false;
        int i = 0;
        while ( 2 * i + 1 < arr.length) {
            boolean left = less(arr[i], arr[2 * i + 1]);
            if (left == false)
                return false;
            if (2 * i + 2 < arr.length) {
                boolean right = less(arr[i], arr[2 * i + 2]);
                if (right == false)
                    return false;
            }
            ++i;
        }
        return true;
    }

    private boolean less(int i, int j) {
        return i < j ? true : false;
    }
}
