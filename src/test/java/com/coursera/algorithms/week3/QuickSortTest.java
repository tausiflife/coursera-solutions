package com.coursera.algorithms.week3;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

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

    @Test
    public void testSortingOfNutsAndBolts() {
        Integer[] nuts = {5, 9, 1, 7, 2, 4};
        Integer[] bolts = {9, 7, 1, 5, 4, 2};
        quickSort.pairOfNutsAndBolts(nuts, bolts);
        Assert.assertArrayEquals(new Integer[]{1, 2, 4, 5, 7, 9}, nuts);
        Assert.assertArrayEquals(new Integer[]{1, 2, 4, 5, 7, 9}, bolts);
    }

    @Test
    public void testKthSmallesElement() {
        int[] arr1 = {1, 3, 4, 7, 10, 12};
        int[] arr2 = {2, 3, 6, 15};
        int k = quickSort.findKthElement(arr1, arr2, 5);
        Assert.assertEquals(4, k);

        k = quickSort.findKthElement(arr1, arr2, 9);
        Assert.assertEquals(12, k);
    }

    @Test
    public void findMedianInSortedArrayOfUnequalLength() {
        int[] arr1 = {1, 3, 4, 7, 10, 12};
        int[] arr2 = {2, 3, 6, 15};
        int k = quickSort.findMedian(arr1, arr2);
        Assert.assertEquals(5, k);
    }

    @Test
    public void findMedianInSortedArrayOfEqualLength() {
        int[] arr1 = {4, 7, 10, 12};
        int[] arr2 = {2, 3, 6, 15};
        int k = quickSort.findMedian(arr1, arr2);
        Assert.assertEquals(6, k);
    }

    @Test
    public void shouldFindMajorityElement() {
        int[] arr1 = {1,2,3,4,2,2,2,2};
        int k = quickSort.findMajorityElement(arr1);
        Assert.assertEquals(2, k);
    }

    @Test
    public void shouldThrowExceptionWhenNoMajorityElementExist() {
        int[] arr1 = {1,2,3,4,5,6,2,2};
        Assertions.assertThrows(NoSuchElementException.class, () -> quickSort.findMajorityElement(arr1));
    }
}
