package com.coursera.algorithms.week4;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PriorityQueueTests {
    private OrderedMaxPriorityQueue<Integer> orderedMaxPriorityQueue;
    private OrderedMinPriorityQueue<Integer> orderedMinPriorityQueue;

    @BeforeEach
    void setUp() {
        orderedMaxPriorityQueue = new OrderedMaxPriorityQueue();
        orderedMaxPriorityQueue.insert(4);
        orderedMaxPriorityQueue.insert(6);
        orderedMaxPriorityQueue.insert(3);
        orderedMaxPriorityQueue.insert(5);

        orderedMinPriorityQueue = new OrderedMinPriorityQueue();
        orderedMinPriorityQueue.insert(4);
        orderedMinPriorityQueue.insert(6);
        orderedMinPriorityQueue.insert(3);
        orderedMinPriorityQueue.insert(5);
    }

    @Test
    void shouldInsertInSortedOrderInMaxPQ() {
        Assert.assertEquals(4, orderedMaxPriorityQueue.size());
        int k = orderedMaxPriorityQueue.delMax();
        Assert.assertEquals(3, k);
        Assert.assertEquals(3, orderedMaxPriorityQueue.size());
    }

    @Test
    void shouldInsertInSortedOrderInMinPQ() {
        Assert.assertEquals(4, orderedMinPriorityQueue.size());
        int k = orderedMinPriorityQueue.delMin();
        Assert.assertEquals(6, k);
        Assert.assertEquals(3, orderedMinPriorityQueue.size());
    }

    @Test
    void shouldAddToBinaryHeap() {
        BinaryHeap binaryHeap = new BinaryHeap(7);
        binaryHeap.insert(4);
        binaryHeap.insert(6);
        binaryHeap.insert(12);
        binaryHeap.insert(15);
        binaryHeap.insert(18);
        binaryHeap.insert(16);
        binaryHeap.insert(20);
        Assert.assertEquals(7, binaryHeap.size());
        Assert.assertEquals(20, binaryHeap.delMax());
        Assert.assertEquals(18, binaryHeap.delMax());
        Assert.assertEquals(16, binaryHeap.delMax());
        Assert.assertEquals(15, binaryHeap.delMax());
    }

    @Test
    void shouldTestBinaryHeapZeroBased() {
        BinaryHeapZeroBased heapZeroBased = new BinaryHeapZeroBased();
        heapZeroBased.insert(4);
        heapZeroBased.insert(6);
        heapZeroBased.insert(12);
        heapZeroBased.insert(15);
        heapZeroBased.insert(18);
        heapZeroBased.insert(16);
        heapZeroBased.insert(20);

        Assert.assertEquals(20, heapZeroBased.delMax());
        Assert.assertEquals(18, heapZeroBased.delMax());
        Assert.assertEquals(16, heapZeroBased.delMax());
        Assert.assertEquals(15, heapZeroBased.delMax());
    }
}
