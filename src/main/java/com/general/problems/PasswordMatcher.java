package com.general.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PasswordMatcher {

    /**
     * Find out how many distinct passwords are there in the array.
     * each password has character from a-z.
     * Pass1 and Pass2 are same if Pass2 can be obtained by swapping, the ith and
     * jth character in Pass1 where (i + j)%2 = 0
     * This swapping can be done repeatedly.
     * @param passwords
     * @return
     */
    public int match(String[] passwords) {
        return Arrays.stream(passwords).map(password -> encodeStrings(password)).collect(Collectors.toSet()).size();
    }

    private String encodeStrings(String password) {
        int MAX_CHAR = 26;
        int[] even = new int[MAX_CHAR];
        int[] odd = new int[MAX_CHAR];
        for (int i = 0; i < password.length(); i++) {
            Character c = password.charAt(i);
            if (i % 2 == 0)
                even[c - 'a']++;
            else
                odd[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < MAX_CHAR; j++) {
            builder.append(even[j])
                    .append("-")
                    .append(odd[j]);
            if (j != MAX_CHAR - 1)
                builder.append(":");
        }
        return builder.toString();
    }
}
