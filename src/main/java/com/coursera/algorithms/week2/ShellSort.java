package com.coursera.algorithms.week2;

public class ShellSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        // we wil use h = 3*h + 1;
        int h = 1;
        while (h < N/3) // Max possible h = N => N = 3 * h + 1 => h < N / 3;
            h = 3 * h + 1;
        while (h > 0) {
            for (int i = h; i < N; i++) { // Start with h but then run till N
                for (int j = i; j >=h; j -=h) { // Start with i and run backwards by h, then compare
                    if (less(a[j] , a[j - h]))
                        exch(a, j , j -h);
                }
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
