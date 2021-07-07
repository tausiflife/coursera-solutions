package com.coursera.algorithms.week3;

import edu.princeton.cs.algs4.Cat;

import java.util.Arrays;
import java.util.Objects;

public class QuickSort {

    public void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public void sortWithMedianOfThree(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(Comparable[] arr, int low, int high) {
        if (high <= low)
            return;
        int partition = partition(arr, low, high);
        sort(arr, low, partition - 1);
        sort(arr, partition + 1, high);
    }

    private void sortWithMedianOfThree(Comparable[] arr, int low, int high) {
        if (high <= low)
            return;
        int medianIndex = calculateMedianOfThree(arr, low, low + (high - low) / 2, high);
        swap(arr, low, medianIndex);
        int partition = partition(arr, low, high);
        sort(arr, low, partition - 1);
        sort(arr, partition + 1, high);
    }

    private int calculateMedianOfThree(Comparable[] arr, int low, int mid, int high) {
        Comparable[] sort = {arr[low], arr[mid], arr[high]};
        Arrays.sort(sort);
        return sort[1] == arr[low] ? low : (sort[1] == arr[mid] ? mid : high);
    }

    private int partition(Comparable[] arr, int low, int high) {
        int left = low, right = high + 1;
        while (true) {
            while (less(arr[++left], arr[low]))
                if (left == high)
                    break;
            while (less(arr[low], arr[--right]))
                if (right == low)
                    break;
            if (left >= right)
                break;
            swap(arr, left, right);
        }
        swap(arr, low, right);
        return right;
    }

    private void swap(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private boolean less(Comparable comparable, Comparable comparable1) {
        return comparable.compareTo(comparable1) < 0 ? true : false;
    }

    /**
     * Given an array of n item , find kth small item.
     *
     * @param arr
     * @param k
     * @return
     */
    public Comparable selectKthElement(Comparable[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (high > low) {
            int partition = partition(arr, low, high);
            if (partition == k)
                return arr[k];
            else if (partition < k)
                high = partition - 1;
            else
                low = partition + 1;
        }
        return arr[k];
    }

    /**
     * With more duplicates the partitioning, all the items equals are moved to one side.
     * If all the items are equal, partitioning swaps each item till left and right cross.
     * Hence runs in quadratic time.
     * Solution use 3-way-partitioning to group equal elements together and sort the rest partition.
     *
     * @param arr
     */
    public void quickSortWithDuplicates(Comparable[] arr) {
        quickSortWithDuplicates(arr, 0, arr.length - 1);
        return;
    }

    public void quickSortWithDuplicates(Comparable[] arr, int low, int high) {
        if (high <= low)
            return;
        int partition = partition(arr, low, high);
        int[] leftAndRightValues = threeWayPartition(arr, low, partition, high);
        quickSortWithDuplicates(arr, low, leftAndRightValues[0]);
        quickSortWithDuplicates(arr, leftAndRightValues[1], high);

    }

    private int[] threeWayPartition(Comparable[] arr, int low, int partition, int high) {
        int left = low, right = high, i = low;
        Comparable pivot = arr[partition];
        while (i <= right) {
            int result = arr[i].compareTo(pivot);
            if (result < 0) {
                swap(arr, i, left);
                left++;
                i++;
            } else if (result == 0) {
                i++;
            } else {
                swap(arr, i, right);
                --right;
            }
        }
        int[] res = {left - 1, right + 1};
        return res;
    }
}
