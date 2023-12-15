package com.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString387 {
    public static void main(String[] args) {
        firstUniqChar("leetcode");
    }
    public static int firstUniqChar(String s) {
        LinkedHashMap<Integer, Character> map = new LinkedHashMap<>();
        for(int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsValue(c)) {
                map.remove(Integer.valueOf(i));
            } else {
                map.put(i,c);
            }
        }
        return map.size() == 0 ? -1 : map.entrySet().stream().findFirst().get().getKey();
    }
}
