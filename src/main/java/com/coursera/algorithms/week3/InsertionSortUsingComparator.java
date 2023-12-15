package com.coursera.algorithms.week3;

import java.util.Comparator;

public class InsertionSortUsingComparator {

    public <T>  void sort(T[] arr, Comparator<T> comparator) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arr[j], arr[j - 1], comparator))
                    swap(arr, j , j -1);
            }
        }
    }

    private <T> boolean less(T t1, T t2, Comparator<T> comparator) {
        return comparator.compare(t1, t2) < 0 ? true : false;
    }

    private <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
