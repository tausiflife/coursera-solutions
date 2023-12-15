package com.coursera.algorithms.week4;

public class BinaryHeapZeroBased<T extends Comparable<T>> {
    private T[] items;
    private int n;
    private static final int CAPACITY = 8;

    public BinaryHeapZeroBased() {
        items = (T[]) new Comparable[CAPACITY];
    }

    public void insert(T item) {
        items[n++] = item;
        swim(n - 1);
    }

    private void swim(int i) {
        int j = i;
        while (j > 0 && less((j - 1) / 2, j)) {
            swap((j - 1) / 2, j);
            j = (j - 1) / 2;
        }
    }

    public T delMax() {
        swap(0, n - 1);
        T item = items[n - 1];
        items[--n] = null;
        sink(0);
        --n;
        return item;
    }

    private void sink(int i) {
        while (2 * i + 1 < n) {
            int j = 2 * i + 1;
            if (j  + 1 < n && less(j, j + 1))
                j = j + 1;
            if (!less(i, j))
                break;
            swap(j, i);
            i = j;
        }
    }

    private void swap(int i, int j) {
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }
}
