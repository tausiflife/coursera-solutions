package com.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrangeNumberForBiggest {

    public static void main(String[] args) {
        ArrangeNumberForBiggest arrangeNumberForBiggest = new ArrangeNumberForBiggest();
        arrangeNumberForBiggest.formBiggestNumber(new String[]{"54","546","548","60", "61"});
    }
    public void formBiggestNumber(String[] nums) {
        Arrays.sort(nums, (first, second)->{
            String firstSecond = first+second;
            String secondFirst = second + first;
            return Integer.valueOf(secondFirst).compareTo(Integer.valueOf(firstSecond));
        });
        String output = Arrays.stream(nums).collect(Collectors.joining());
        System.out.println(output);
    }
}
