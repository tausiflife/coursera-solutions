package com.general.problems;

import com.coursera.algorithms.week4.BinaryHeap;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class GeneralProblemsTests {

    @Test
    public void shouldTestIfMinHeap() {
        int[] arr = {1,2,3,4,5,6,7};
        Assert.assertTrue(new CheckMinHeap().isMinHeap(arr));
        int[] arr1 = {1,4,3,2,5,6,7};
        Assert.assertFalse(new CheckMinHeap().isMinHeap(arr1));
        int[] arr2 = {1,2,3,4,5,6,3};
        Assert.assertFalse(new CheckMinHeap().isMinHeap(arr2));
    }
}
