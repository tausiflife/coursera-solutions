package com.leetcode;

public class RepeatedStringPattern459 {
    public static void main(String[] args) {
        RepeatedStringPattern459 repeatedStringPattern459 = new RepeatedStringPattern459();
        repeatedStringPattern459.repeatedSubstringPattern("abab");
    }
    public boolean repeatedSubstringPattern(String s) {
        if( s== null || "".equals(s))
            return false;
        int halfLength = s.length() / 2;
        for(int i = 1; i <= halfLength; i++) {
            if(s.length() % i == 0) {
                String repeatedSubStr = s.substring(0, i).repeat(s.length() / i);
                if(repeatedSubStr.equals(s))
                    return true;
            }

        }
        return false;
    }
}
