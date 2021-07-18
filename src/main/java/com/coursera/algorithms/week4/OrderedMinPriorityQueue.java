package com.coursera.algorithms.week4;

public class OrderedMinPriorityQueue<Key extends Comparable<Key>> {
    private Key[] items;
    private int n;
    private static final int CAPACITY = 8;

    public OrderedMinPriorityQueue() {
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
        int max = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (less(max, i)) {
                swap(max, i);
                max = i;
            } else
                break;
        }

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
