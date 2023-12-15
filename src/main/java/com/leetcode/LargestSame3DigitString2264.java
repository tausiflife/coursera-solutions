package com.leetcode;

public class LargestSame3DigitString2264 {
    public static void main(String[] args) {
        LargestSame3DigitString2264 n = new LargestSame3DigitString2264();
        System.out.println(n.largestGoodInteger("11"));
    }

    public String largestGoodInteger(String num) {
        int maxGoodInteger = Integer.MIN_VALUE;String maxGoodIntegerStr = "";
        int start = 0;
        while(start < num.length()) {
            int end = start + 1;
            int count =0;
            while(end < num.length() && num.charAt(start) == num.charAt(end)) {
                end++;
                count++;
                if(count == 2)
                    break;
            }
            String currSubStr = num.substring(start, end);
            if(count == 2 && Integer.valueOf(currSubStr) > maxGoodInteger) {
                maxGoodInteger = Integer.valueOf(currSubStr);
                maxGoodIntegerStr = currSubStr;
            }
            start = end;
        }
        return maxGoodIntegerStr;
    }
}
