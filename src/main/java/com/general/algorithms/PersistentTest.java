package com.general.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersistentTest {

    static Integer[] splitArray(int[] arr) {
        List<Integer> even =  Arrays.stream(arr).boxed().filter(e -> e % 2 == 0).collect(Collectors.toList());
        List<Integer> odd =  Arrays.stream(arr).boxed().filter(e -> e % 2 != 0).collect(Collectors.toList());
        odd.addAll(even);
        return odd.toArray(new Integer[arr.length]);

    }

    static int testTry() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }
    public static void main(String[] args) {
        Integer[] result = splitArray(new int[]{1,4,5,2,3});
        System.out.println(testTry());
    }
}
