package com.leetcode;

public class LargestPalindromicProduct {
    public static void main(String[] args) {
        System.out.println(largestProduct(99,99));
    }

    private static int largestProduct(int num1, int num2) {
        if(num1 == 0 || num2 == 0)
            return 0;
        int product = num1 * num2;
        if(isPalindromic(product))
            return product;
        int left = largestProduct(num1-1, num2);
        int right = largestProduct(num1, num2-1);
        if(left > right)
            return left;
        return right;
    }

    private static boolean isPalindromic(int product) {
        String s = String.valueOf(product);
        int n = s.length();
        for(int i=0; i<n; i++) {
            if(s.charAt(i) != s.charAt(n-1-i))
                return false;
        }
        return true;
    }
}
