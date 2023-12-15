package com.leetcode;

import java.util.List;

public class CheckIfStringIsAcronym2828 {
    public boolean isAcronym(List<String> words, String s) {
        StringBuilder acr = words.stream()
                .map(str -> str.charAt(0))
                .collect(() -> new StringBuilder(), (sb, c)-> sb.append(c), (sb1, sb2) -> sb1.append(sb2.toString()));
        return acr.equals(s);
    }
}
