package com.general.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet<T> {

    public Set<Set<T>> powerSet(Set<T> set) {
        int size = set.size();
        //Number of elements in the power set is nC0 + nC1 + ... + nCn = 2^n
        int powerSetSize = (int) Math.pow(2, size);
        //Convert set to list to get hold of things in sequence
        List<T> list = new ArrayList<>(set);
        //Run loop for power set size with each number checking which all bits are set
        // This can be done by checking with a number with only that bit set
        // Let x = 010, to find which bit is set, we run loop 2 {0,1,2} times.
        // Loop2 shifts 1 to left by the loop 2 index i.e 1 << 0 = 1(001), 1 << 1 = 2(010), 1 << 2 = 4(100) ...
        //We bit wise and the number with shifted number x & (1 << i). If this is zero than the number has no set bit
        // at ith location
        Set<Set<T>> powerSet = new HashSet<>(powerSetSize);
        for (int i = 0; i < powerSetSize; i++) {
            Set<T> subset = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(list.get(j));
                }
            }
            powerSet.add(subset);
        }
        return powerSet;
    }
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++)
            for (int j = i; j > 0; j--)
                if (less(a[j], a[j - 1]))
                    exch(a, j, j - 1);
                else break;
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


