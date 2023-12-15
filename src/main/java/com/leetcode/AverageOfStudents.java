package com.leetcode;

import java.util.*;

/**
 * GIven a 2d string array that contains studentname, grade
 * . There can be 1 or more grades per student.
 * Return max avg grade among students.
 */
public class AverageOfStudents {
    public static void main(String[] args) {
        List<List<String>> studentGrades = new ArrayList<>();
        //store the count and sum as value against the student
        Map<String, Integer[]> map = new HashMap<>();
        //iterate the list and update the map
        for(List<String> studentGrade : studentGrades) {
            Integer[] sumCount = map.getOrDefault(studentGrade.get(0), new Integer[2]);
            sumCount[0] += Integer.valueOf(studentGrade.get(1));
            sumCount[1] +=1;
            map.put(studentGrade.get(0), sumCount);
        }

        //iterate the map to find the max avg
        long maxAvg = 0l;
        for(Map.Entry<String, Integer[]> entrySet : map.entrySet()) {
            maxAvg = Math.max(maxAvg, entrySet.getValue()[0]/entrySet.getValue()[1]);
        }
    }
}
