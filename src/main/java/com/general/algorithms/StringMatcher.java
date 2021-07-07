package com.general.algorithms;

public class StringMatcher {

    /**
     * Two strings, if second string is the substring of first.
     */

    public boolean isSubString(String original, String str) {
        if (original == null || str == null || original.isEmpty() || str.isEmpty())
            return false;
        char[] originalArray = original.toCharArray();
        char[] chars = str.toCharArray();
        int length = 0;
        for (int i = 0; i < originalArray.length; i++) {
            if (length < chars.length && originalArray[i] == chars[length]) {
                length++;
            } else {
                length = 0;
            }
            if (length == chars.length)
                return true;
        }
        return false;
    }
}
