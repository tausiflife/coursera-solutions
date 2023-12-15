package com.algo1.week3;

import java.util.Arrays;

public class InterviewQuestions {
    
    public static void sortNutsAndBolts(Comparable[] nuts, Comparable[] bolts) {
        sort(nuts, bolts, 0, nuts.length - 1);
    }
    
    private static void sort(Comparable[] nuts, Comparable[] bolts, int lo, int hi) {
        if (hi <= lo)
            return;
        int m = medianOfThree(nuts, lo, lo + (hi - lo)/2, hi);
        swap(nuts, lo, m);
        int n = partition(nuts, nuts[lo], lo, hi);
        int b = partition(bolts, nuts[n], lo, hi);
        sort(nuts, bolts, lo, n - 1);
        sort(nuts, bolts, n + 1, hi);
    }

    private static int medianOfThree(Comparable[] nuts, int a, int b, int c) {
        Comparable[] tmp = {nuts[a], nuts[b], nuts[c]};
        Arrays.sort(tmp);
        if (tmp[1] == nuts[a])
            return a;
        else if (tmp[1] == nuts[b])
            return b;
        else
            return c;
    }

    private static int partition(Comparable[] arr, Comparable cmp, int lo, int hi) {
        int i = lo, j = hi;
        while (true) {
            while (less(arr[i], cmp)) {
                ++i;
            }
            if (i == hi) {
                break;
            }
            while (less(cmp, arr[j])) {
                --j;
            }
            if (j == lo) {
                break;
            }
            if (i >= j)
                break;
            swap(arr, i , j);
        }
        return j;
    }

    private static boolean less(Comparable a, Comparable b) {
        int v = a.compareTo(b);
        return v == -1;
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public Comparable select(Comparable[] a,Comparable[] b, int k) {
        int n = a.length + b.length;
        validateK(k, n);
        Comparable[] tmp = new Comparable[n];
        int i = 0, j = 0, m = 0;
        while (i < a.length && j < b.length) {
            if (a[i].compareTo(b[j]) < 0) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[i++];
            }
        }
        while (i < a.length) {
            tmp[k++] = a[i++];
        }
        while (j < b.length) {
            tmp[k++] = b[j++];
        }
        return tmp[k - 1];
    }

    private void validateK(int k, int n) {
        if (k < 0 || k > n)
            throw new IllegalArgumentException("K not within range");
    }

    public static void main(String[] args) {
        Integer[] nuts = { 9, 2, 4, 8, 3, 7, 10 };
        Integer[] bolts = { 7, 2, 8, 4, 9, 10, 3 };;
        sortNutsAndBolts(nuts, bolts);
    }
}
