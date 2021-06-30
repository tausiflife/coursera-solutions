package com.coursera.algorithms.week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class InsertionSortUsingComparatorTest {

    @Test
    public void testInsertionSortUsingComparator() {
        InsertionSortUsingComparator insertionSortUsingComparator = new InsertionSortUsingComparator();
        Comparator<Integer> comparator = (t1, t2) -> t1.compareTo(t2);
        Integer[] arr = {1,3,2,5,4};
        insertionSortUsingComparator.sort(arr, comparator);
        Assertions.assertArrayEquals(new Integer[]{1,2,3,4,5}, arr);
    }

    @Test
    public void testInsertionSortUsingComparatorReverse() {
        InsertionSortUsingComparator insertionSortUsingComparator = new InsertionSortUsingComparator();
        Comparator<Integer> comparator = (t1, t2) -> t2.compareTo(t1);
        Integer[] arr = {1,3,2,5,4};
        insertionSortUsingComparator.sort(arr, comparator);
        Assertions.assertArrayEquals(new Integer[]{5,4,3,2,1}, arr);
    }
}
