package com.coursera.algorithms.week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Permutation {

    public boolean isArrayPermutation(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        Map<Integer, Long> intCount = Arrays.stream(arr1).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (int i = 0; i < arr2.length; i++) {
            int elem = arr2[i];
            if (intCount.containsKey(elem) && intCount.get(elem) > 0)
                intCount.put(elem, intCount.get(elem) - 1);
            else
                return false;
        }
        return true;
    }
}
