package com.coursera.algorithms.week4;

import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Dynamic median. Design a data type that supports insert in logarithmic time,
 * find-the-median in constant time, and remove-the-median in logarithmic time.
 * If the number of keys in the data type is even, find/remove the lower median.
 */
public class DynamicMedian<T extends Comparable<T>> {
    private PriorityQueue<T> lowers;
    private PriorityQueue<T> highers;

    public DynamicMedian() {
        lowers = new PriorityQueue<>((a, b) -> b.compareTo(a)); //custom comparator as we need lowers here.
        highers = new PriorityQueue<>();
    }

    public void add(T key) {
        addElement(key);
        reBalance();
    }

    private void addElement(T key) {
        if (lowers.isEmpty() || key.compareTo(lowers.peek()) < 0)
            lowers.add(key);
        else
            highers.add(key);
    }

    private void reBalance() {
        PriorityQueue<T> smaller = getSmallerHeap();
        PriorityQueue<T> larger = getLargerHeap();
        if (larger.size() - smaller.size() >=2)
            smaller.add(larger.poll());
    }

    private PriorityQueue<T> getSmallerHeap() {
        return lowers.size() < highers.size() ? lowers : highers;
    }

    private PriorityQueue<T> getLargerHeap() {
        return lowers.size() > highers.size() ? lowers : highers;
    }

    public T median() {
        if (lowers.size() == highers.size())
            return lowers.peek();
        return getLargerHeap().peek();
    }
}
