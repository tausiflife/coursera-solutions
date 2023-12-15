package com.coursera.algorithms.week3;

import java.util.Arrays;

public class MergeSort {

    private final static int CUTOFF = 7;

    public void mergeSort(Comparable[] arr) {
        if (arr == null || arr.length == 0)
            return;
        Comparable[] aux = new Comparable[arr.length];
        mergeSort(arr,aux, 0, arr.length - 1);
    }

    private void mergeSort(Comparable[] arr, Comparable[] aux, int low, int high) {
        if (high <= low)
            return;
        if (high <= low + CUTOFF - 1)
        {
            // do Insertion.sort(a, lo, hi);
            return;
        }

        int mid = low + (high - low)/2;
        mergeSort(arr, aux, low, mid);
        mergeSort(arr, aux, mid + 1, high);
        if (!less(arr[mid +1], arr[mid]))
            return;
        merge(arr, aux, low, mid, high);
    }

    private void merge(Comparable[] arr, Comparable[] aux, int low, int mid, int high) {
        for (int i = low; i <=high; i++)
            aux[i] = arr[i];
        int leftCounter = low;
        int rightCounter = mid + 1;
        for (int i = low; i <= high; i++) {
            if (leftCounter > mid)
                arr[i] = aux[rightCounter++];
            else if (rightCounter > high)
                arr[i] = aux[leftCounter++];
            else if (less(aux[leftCounter], aux[rightCounter]))
                arr[i] = aux[leftCounter++];
            else
                arr[i] = aux[rightCounter++];
        }
    }

    private boolean less(Comparable comparable, Comparable comparable1) {
        return comparable.compareTo(comparable1) < 0 ? true : false;
    }

    /**
     * Merging with smaller auxiliary array. Suppose that the subarray a[0] to a[n−1] is sorted and the subarray a[n]
     * to a[2∗n−1] is sorted.
     * How can you merge the two subarrays so that a[0] to a[2∗n−1] is sorted using an auxiliary array of length n
     * (instead of 2n)?
     * @param arr
     * @param n
     */
    public void mergeWithSmallerAuxiliaryArray(int[] arr, int n) {
        int[] aux = new int[n];
        for (int i = 0; i < n; i++) {
            aux[i] = arr[i];
        }
        int k = 0, i = 0, j = n;
        while (k < 2 * n) {
            if (i > n - 1)
                arr[k++] = arr[j++];
            else if (j > 2 * n)
                arr[k++] = aux[i++];
            else if (less(aux[i], arr[j]))
                arr[k++] = aux[i++];
            else
                arr[k++] = arr[j++];
        }
    }

    /**
     * An inversion in an array a[] is a pair of entries a[i] and a[j] such that i<j but a[i] > a[j].
     * Given an array, design a linearithmic algorithm to count the number of inversions.
     * @param arr
     * @return
     */
    public int countInversions(int[] arr) {
        int[] aux = new int[arr.length];
        return countInversions(arr,aux,0, arr.length - 1);
    }

    private int countInversions(int[] arr,int[] aux, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            count += countInversions(arr, aux, low, mid);
            count += countInversions(arr, aux, mid + 1, high);
            count += countInversionsMerge(arr, aux, low, mid, high);

        }
        return count;
    }

    private int countInversionsMerge(int[] arr, int[] aux, int low, int mid, int high) {
        int[] left = Arrays.copyOfRange(arr, low, mid + 1);
        int[] right = Arrays.copyOfRange(arr, mid + 1, high + 1);
        int k = low, i = 0, j = 0, count = 0;
        while (k <= high) {
            if (i > left.length - 1)
                arr[k++] = right[j++];
            else if (j > right.length - 1)
                arr[k++] = left[i++];
            else if (less(left[i], right[j]))
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                count += mid - i + 1;
            }
        }
        return count;
    }
}
