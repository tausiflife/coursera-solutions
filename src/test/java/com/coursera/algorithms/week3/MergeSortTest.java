package com.coursera.algorithms.week3;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeSortTest {
    private MergeSort mergeSort = new MergeSort();

    @Test
    public void testMergeSort() {
        Integer[] arr = {1, 5, 2, 6, 3, 7, 4};
        mergeSort.mergeSort(arr);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7}, arr);
    }

    @Test
    public void testMergeSortNull() {
        mergeSort.mergeSort(null);
    }

    @Test
    public void testMergeSortOneElement() {
        mergeSort.mergeSort(new Integer[]{1});

    }

    @Test
    public void testMergeWithSmallerAuxiliaryArray() {
        int[] arr = new int[]{1, 22, 33, 44, 55, 12, 18, 19, 23, 56};
        mergeSort.mergeWithSmallerAuxiliaryArray(arr, 5);
        Assertions.assertArrayEquals(new int[]{1, 12, 18, 19, 22, 23, 33, 44, 55, 56}, arr);
    }

    @Test
    public void testCountInversions() {
        int[] arr = { 1, 20, 6, 4, 5 };
        int count = mergeSort.countInversions(arr);
        Assertions.assertEquals(5, count);
    }
}
