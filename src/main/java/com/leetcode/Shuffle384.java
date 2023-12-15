package com.leetcode;

import java.util.Arrays;
import java.util.Random;

public class Shuffle384 {
    private int[] original;
    private int[] shuffle;

    public Shuffle384(int[] nums) {
        this.original = nums;
        this.shuffle = nums.clone();
    }

    public int[] reset() {
        this.shuffle = original.clone();
        return shuffle;
    }

    public int[] shuffle() {
        for (int i = 0; i < shuffle.length; i++) {
            int swapIndex = (int) (Math.random() * (i + 1));
            int temp = shuffle[i];
            shuffle[i] = shuffle[swapIndex];
            shuffle[swapIndex] = temp;
        }
        return shuffle;
    }

    public static void main(String[] args) {
        Shuffle384 shuffle384 = new Shuffle384(new int[]{1,2,3,4,5});
        Arrays.stream(shuffle384.reset()).forEach(System.out::println);
        System.out.println("Reset done");
        Arrays.stream(shuffle384.shuffle()).forEach(System.out::println);
        System.out.println("Shuffle done");
        Arrays.stream(shuffle384.reset()).forEach(System.out::println);
        System.out.println("Reset done");
        Arrays.stream(shuffle384.shuffle()).forEach(System.out::println);
        System.out.println("Shuffle done");
    }
}
