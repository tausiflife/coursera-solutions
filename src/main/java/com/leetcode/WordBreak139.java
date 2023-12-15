package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class WordBreak139 {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Map<String, Map<String, Double>> map = list.stream().collect(Collectors.groupingBy(Employee::getDept,
                Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getSalary))));
    }
    private static class Employee {
        String dept;
        String gender;
        int salary;

        public int getSalary() {
            return salary;
        }

        public String getDept() {
            return dept;
        }

        public String getGender() {
            return gender;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int minLength = wordDict.stream().map(String::length)
                .min((a,b) -> a.compareTo(b)).get();
        int start = minLength, end = minLength;
        Set<String> seen = new HashSet<>();
        while (end < s.length()) {
            String substr = s.substring(start, end + 1);
            if(wordDict.contains(substr) ) {
                end++;
            } else {

            }
        }
        return false;
    }

    public static class PrintNumberUsingThread {
    }
}
