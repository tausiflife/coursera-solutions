package com.coursera.algorithms.week4;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class DynamicMedianTest {
    private DynamicMedian<Integer> dynamicMedian = new DynamicMedian<>();

    @Test
    void shouldGetMedianForOddElements() {
        dynamicMedian.add(1);
        dynamicMedian.add(2);
        dynamicMedian.add(3);
        dynamicMedian.add(4);
        dynamicMedian.add(5);
        Assert.assertTrue(3 == dynamicMedian.median());
    }

    @Test
    void shouldGetMedianForEvenElements() {
        dynamicMedian.add(1);
        dynamicMedian.add(2);
        dynamicMedian.add(3);
        dynamicMedian.add(4);
        dynamicMedian.add(5);
        dynamicMedian.add(6);
        Assert.assertTrue(3 == dynamicMedian.median());
    }

    @Test
    void shouldGetMedianForRandomElements() {
        dynamicMedian.add(21);
        dynamicMedian.add(2);
        dynamicMedian.add(18);
        dynamicMedian.add(4);
        dynamicMedian.add(5);
        dynamicMedian.add(24);
        dynamicMedian.add(14);
        dynamicMedian.add(11);

        Assert.assertTrue(11 == dynamicMedian.median());
    }
}
