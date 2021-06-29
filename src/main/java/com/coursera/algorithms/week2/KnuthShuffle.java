package com.coursera.algorithms.week2;

import java.util.Random;

public class KnuthShuffle<T> {
    public void shuffle(T[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            Random random = new Random(i);
            int r = random.nextInt();
            if (r != i)
                swap(arr, i, r);
        }
    }

    private void swap(T[] arr, int i, int r) {
        T tmp = arr[i];
        arr[i] = arr[r];
        arr[r] = arr[i];
    }
}
