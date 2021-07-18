package com.coursera.algorithms.week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeapSortTest {
    private HeapSort heapSort = new HeapSort();

    @Test
    void shouldTestHeapSort() {
        Integer[] arr = {12, 15, 4, 6, 18, 16, 20};
        heapSort.sort(arr);
        Assertions.assertArrayEquals(new Integer[]{4, 6, 12, 15, 16, 18, 20}, arr);
    }
}
