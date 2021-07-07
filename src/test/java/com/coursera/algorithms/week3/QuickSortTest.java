package com.coursera.algorithms.week3;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class QuickSortTest {
    private QuickSort quickSort = new QuickSort();

    @Test
    public void testQuickSort() {
        Integer[] arr = {1, 4, 2, 6, 3, 5, 7, 8, 9};
        quickSort.sort(arr);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
    }

    @Test
    public void testSelectKthElement() {
        Integer[] arr = {1, 4, 2, 6, 3, 5, 7, 8, 9};
        Integer elem = (Integer) quickSort.selectKthElement(arr, 8);
        Assert.assertTrue(elem == 9);
    }

    @Test
    public void testQuickSortWithDuplicates() {
        Integer[] arr = {5, 3, 2, 2, 4, 5, 9, 5, 2, 8, 5, 1};
        quickSort.quickSortWithDuplicates(arr);
        Assert.assertArrayEquals(new Integer[]{1, 2, 2, 2, 3, 4, 5, 5, 5, 5, 8, 9}, arr);
    }
}
