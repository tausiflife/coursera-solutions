package com.coursera.algorithms.week4;

import edu.princeton.cs.algs4.MinPQ;

import java.util.Comparator;

public class QueueUsingPQ<T> {
    private MinPQ<Pair<Integer, T>> items;
    private int indexCount;
    private Comparator<Pair<Integer, T>> BY_INDEX = (a, b) -> a.getKey().compareTo(b.getKey());

    public QueueUsingPQ() {
        items = new MinPQ<Pair<Integer, T>>(BY_INDEX);
        indexCount = 0;
    }

    public void push(T item) {
        items.insert(new Pair<>(indexCount++, item));
    }

    public T pop() {
        Pair<Integer, T> pair = items.delMin();
        return pair.getValue();
    }
}
