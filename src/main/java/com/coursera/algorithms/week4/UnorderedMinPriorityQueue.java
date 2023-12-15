package com.coursera.algorithms.week4;

public class UnorderedMinPriorityQueue<Key extends Comparable<Key>> {
    private Key[] items;
    private int n;
    private static final int CAPACITY = 8;

    public UnorderedMinPriorityQueue() {
        items = (Key[]) new Comparable[CAPACITY];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(Key key) {
        items[n++] = key;
        if (n == items.length)
            resize(2 * items.length);
    }

    private void resize(int newLength) {
        Key[] newItems = (Key[]) new Comparable[newLength];
        for (int i = 0; i < n; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

    public Key delMin() {
        int min = 0;
        for (int i = 1; i < n; i++) {
            if (less(i, min))
                min = i;
        }
        swap(min, n - 1);
        Key key = items[n - 1];
        items[--n] = null;
        return key;
    }

    private void swap(int i, int j) {
        Key tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }
}
