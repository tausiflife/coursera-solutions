package com.leetcode;

import java.math.BigInteger;

public class Subsequence {
    public static void main(String[] args) {
        printSubsequence(new int[]{1,2,3,4}, 4);
    }
    public static void printSubsequence(int[] arr, int n) {
        //number of subsequence in 2^(n -1)
        int opsize = (int) Math.pow(2 ,n);
        for(int counter =1 ; counter< opsize; counter++) {
            for(int j =0; j<n;j++) {
                if(BigInteger.valueOf(counter).testBit(j))
                    System.out.print(arr[j]);
            }
            System.out.println();
        }
    }
}
