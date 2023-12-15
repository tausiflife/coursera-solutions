package com.coursera.algorithms.week4;

import org.junit.Assert;
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

    @Test
    public void testPairEquals() {
        Pair<Integer, Integer> pair = new Pair<>(1,2);
        Pair<Integer, Integer> pair1 = new Pair<>(1,2);
        Assert.assertEquals(0, pair.compareTo(pair1));
    }

    @Test
    public void testPairLess() {
        Pair<Integer, Integer> pair = new Pair<>(0,2);
        Pair<Integer, Integer> pair1 = new Pair<>(1,2);
        Assert.assertEquals(-1, pair.compareTo(pair1));
    }

    @Test
    public void testPairGreater() {
        Pair<Integer, Integer> pair = new Pair<>(2,2);
        Pair<Integer, Integer> pair1 = new Pair<>(1,2);
        Assert.assertEquals(1, pair.compareTo(pair1));
    }

    @Test
    public void testStackUsingPQ() {
        StackUsingPQ<Integer> integerStackUsingPQ = new StackUsingPQ<>();
        integerStackUsingPQ.push(3);
        integerStackUsingPQ.push(4);
        integerStackUsingPQ.push(10);
        integerStackUsingPQ.push(13);
        integerStackUsingPQ.push(1);
        integerStackUsingPQ.push(6);
        integerStackUsingPQ.push(30);
        Assert.assertEquals(30, (int)integerStackUsingPQ.pop());
        Assert.assertEquals(6, (int)integerStackUsingPQ.pop());
        integerStackUsingPQ.push(20);
        Assert.assertEquals(20, (int)integerStackUsingPQ.pop());
        Assert.assertEquals(1, (int)integerStackUsingPQ.pop());
        Assert.assertEquals(13, (int)integerStackUsingPQ.pop());
        Assert.assertEquals(10, (int)integerStackUsingPQ.pop());
        Assert.assertEquals(4, (int)integerStackUsingPQ.pop());
        Assert.assertEquals(3, (int)integerStackUsingPQ.pop());
    }

    @Test
    public void testQueueUsingPQ() {
        QueueUsingPQ<Integer> integerQueueUsingPQ = new QueueUsingPQ<>();
        integerQueueUsingPQ.push(3);
        integerQueueUsingPQ.push(4);
        integerQueueUsingPQ.push(10);
        integerQueueUsingPQ.push(13);
        integerQueueUsingPQ.push(1);
        integerQueueUsingPQ.push(6);
        integerQueueUsingPQ.push(30);
        Assert.assertEquals(3, (int)integerQueueUsingPQ.pop());
        Assert.assertEquals(4, (int)integerQueueUsingPQ.pop());
        integerQueueUsingPQ.push(20);
        Assert.assertEquals(10, (int)integerQueueUsingPQ.pop());
        Assert.assertEquals(13, (int)integerQueueUsingPQ.pop());
        Assert.assertEquals(1, (int)integerQueueUsingPQ.pop());
        Assert.assertEquals(6, (int)integerQueueUsingPQ.pop());
        Assert.assertEquals(30, (int)integerQueueUsingPQ.pop());
        Assert.assertEquals(20, (int)integerQueueUsingPQ.pop());
    }
}
