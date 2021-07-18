package com.coursera.algorithms.week4;

public class HeapSort {
    public void sort(Comparable[] arr) {
        int N = arr.length;
        for (int k = N / 2; k >= 0; k--)
            sink(arr, k, N);
        while (N > 0) {
            swap(arr, 0, --N);
            sink(arr, 0, N);
        }
    }

    private void sink(Comparable[] arr, int k, int n) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && less(arr, j, j + 1))
                j = j + 1;
            if (!less(arr, k, j))
                break;
            swap(arr, k, j);
            k = j;
        }
    }

    private void swap(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private boolean less(Comparable[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }
}
