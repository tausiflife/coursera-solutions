package com.coursera.algorithms.week3;

import java.util.Arrays;

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


    /**
     * A disorganized carpenter has a mixed pile of n nuts and n bolts. The goal is to find the corresponding pairs
     * of nuts and bolts. Each nut fits exactly one bolt and each bolt fits exactly one nut. By fitting a nut and a
     * bolt together, the carpenter can see which one is bigger (but the carpenter cannot compare two nuts or two
     * bolts directly). Design an algorithm for the problem that uses at most proportional to nlogn compares (probabilistically).
     *
     * @param nuts
     * @param bolts
     */
    public void pairOfNutsAndBolts(Comparable[] nuts, Comparable[] bolts) {
        sortPairOfNutsAndBolts(nuts, bolts, 0, nuts.length - 1);
    }

    private void sortPairOfNutsAndBolts(Comparable[] nuts, Comparable[] bolts, int low, int high) {
        if (high <= low)
            return;
        int partition = partition(nuts, bolts[low], low, high);
        partition(bolts, nuts[partition], low, high);
        sortPairOfNutsAndBolts(nuts, bolts, low, partition - 1);
        sortPairOfNutsAndBolts(nuts, bolts, partition + 1, high);
    }

    private int partition(Comparable[] nuts, Comparable comparedAgainst, int low, int high) {
        int left = low, right = high;
        while (true) {
            while (less(nuts[left], comparedAgainst)) {
                ++left;
                if (left == high)
                    break;
            }
            while (less(comparedAgainst, nuts[right])) {
                --right;
                if (right == low)
                    break;
            }
            if (left >= right)
                break;
            swap(nuts, left, right);
        }
        return right;
    }

    /**
     * Selection in two sorted arrays. Given two sorted arrays a[] and b[], of lengths n1 and n2
     * and an integer 0 <= k <=n1+n2 design an algorithm to find a key of rank k.
     * The order of growth of the worst case running time of your algorithm should be logn, where n = n1 + n2
     * Version 1: n1=n2 (equal length arrays) and k=n/2 (median).
     * Version 2: k=n/2 (median).
     * Version 3: no restrictions.
     *
     * @param arr1
     * @param arr2
     * @param k
     * @return
     */
    public int findKthElement(int[] arr1, int[] arr2, int k) {
        if (k == 0 || k > (arr1.length + arr2.length))
            throw new IllegalArgumentException("");
        int n = arr1.length, m = arr2.length;
        if (n > m) //because we want to do binary search in smallest array.
            return findKthElement(arr2, arr1, k);
        int minNumberOfElementsFromArr1 = Math.max(0, k - m), maxNumberOfElementsFromArr1 = Math.min(k, n);
        while (minNumberOfElementsFromArr1 <= maxNumberOfElementsFromArr1) {
            int partitionArr1 = minNumberOfElementsFromArr1 + (maxNumberOfElementsFromArr1 - minNumberOfElementsFromArr1) / 2;
            int partitionArr2 = k - partitionArr1;
            int largestElementToLeftOfPartition1 = partitionArr1 == 0 ? Integer.MIN_VALUE : arr1[partitionArr1 - 1];
            int smallestElementRightOfPartition1 = partitionArr1 == n ? Integer.MAX_VALUE : arr1[partitionArr1];
            int largestElementToLeftOfPartition2 = partitionArr2 == 0 ? Integer.MIN_VALUE : arr2[partitionArr2 - 1];
            int smallestElementRightOfPartition2 = partitionArr2 == m ? Integer.MAX_VALUE : arr2[partitionArr2];
            if (largestElementToLeftOfPartition1 <= smallestElementRightOfPartition2
                    && largestElementToLeftOfPartition2 <= smallestElementRightOfPartition1)
                return Math.max(largestElementToLeftOfPartition1, largestElementToLeftOfPartition2);
            else if (largestElementToLeftOfPartition1 > smallestElementRightOfPartition2)
                maxNumberOfElementsFromArr1 = partitionArr1 - 1;
            else
                minNumberOfElementsFromArr1 = partitionArr1 + 1;
        }
        throw new IllegalArgumentException();
    }
}
