package com.coursera.algorithms.week1;

public class PeakElement {

    /**
     * Returns index of the peak element
     * @param arr
     * @return
     */
    public int findPeak(int[] arr) {

        return findPeakUtil(arr, 0, arr.length - 1);
    }

    public int findPeakUtil(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        //compare middle element with its neighbours, if they exist
        if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1]))
            return mid;
        else if(mid > 0 && arr[mid - 1] > arr[mid]) //compare with its left
            return findPeakUtil(arr, low, mid - 1);
        else
            return findPeakUtil(arr, mid + 1, high);
    }
}
