package com.coursera.algorithms.week4;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizedPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int size;
    private static final int CAPACITY = 8;

    public RandomizedPriorityQueue() {
        items = (T[]) new Comparable[CAPACITY];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(T key) {
        items[size++] = key;
        swim(size - 1);
    }

    public T peek() {
        return items[0];
    }

    public T poll() {
        T item = items[--size];
        swap(0, size);
        sink(0);
        items[size] = null;
        return item;
    }

    private void sink(int i) {
        while (2* i + 1 < size) {
            int j = 2* i + 1;
            if (j + 1 < size && less(j, j + 1))
                ++j;
            if (!less(i, j))
                break;
            swap(i , j);
            i = j;
        }
    }

    private void swim(int i) {
        int j = i;
        while (j >= 0 && less((j - 1)/2, j)) {
            swap((j - 1)/2, j);
            j = (j - 1)/2;
        }
    }

    private void swap(int i, int j) {
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    private boolean less(int i, int j) {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
