package com.coursera.algorithms.week4;

public class HeapSort {

    /**
     * The for loop constructs the heap; then the while loop exchanges the largest element a[1]
     * with a[N] and then repairs the heap, continuing until the heap is empty. Decrementing the array indices
     * in the implementations of exch() and less() gives an implementation that sorts a[0] through
     * a[N-1], consistent with our other sorts.
     * @param arr
     */
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
