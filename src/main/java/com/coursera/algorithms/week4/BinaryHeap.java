package com.coursera.algorithms.week4;

/**
 * Array representation of heap ordered complete binary tree.
 * Parents key no smaller than child's key.
 * Indices start at 1. 0 Is the virtual root of all item.
 * Children are at 2k and 2k + 1
 * Tree with N nodes has a height of log N
 *
 * @param <Key>
 */
public class BinaryHeap<Key extends Comparable<Key>> {
    private Key[] items;
    private int n;
    private static final int INITIAL_CAPACITY = 8;

    public BinaryHeap(int size) {
        items = (Key[]) new Comparable[size + 1]; //+1 to store the virtual root.
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(Key key) {
        items[++n] = key;
        swim(n);
    }

    private void swim(int n) {
        int j = n;
        while (j > 1 && less(j/2, j)) {
            swap(j/2, j);
            j = j/2;
        }
    }

    public Key delMax() {
        swap(1, n);
        Key key = items[n];
        items[n--] = null;
        sink(1);
        return key;
    }

    private void sink(int i) {
        while (2 * i <=n) {
            int j = 2 * i;
            if (j < n && less(j, j + 1)) // we are going to swap the largest of the two
                j++;
            if (!less(i, j))
                break;
            swap(i, j);
            i = j;
        }
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
