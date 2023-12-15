package com.leetcode;

import java.util.*;

public class MinHalls {
    public static void main(String[] args) {
        int lectures[][] = {{ 0, 5 },
                { 1, 2 },
                { 1, 10 }};
        System.out.println(minHalls(lectures));

    }

    public static int minHalls(int[][] intervals) {
        if(intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Queue<Integer> queue = new PriorityQueue<>(intervals.length, (a, b) -> a-b);
        queue.add(intervals[0][1]);
        int count = 0;
        for(int i =1; i< intervals.length; i++) {
            if(intervals[i][0] >= queue.peek()) {
                queue.poll();
                count++;
            }
            queue.add(intervals[i][1]);
        }
        return queue.size();
    }
}
