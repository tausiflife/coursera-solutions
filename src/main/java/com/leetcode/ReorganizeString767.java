package com.leetcode;

import java.util.PriorityQueue;

public class ReorganizeString767 {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        //Max heap
        var heap = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1], a[1]));
        for(int i=0; i < count.length; i++) {
            if(count[i] > 0)
                heap.add(new int[]{ i + 'a', count[i]});
        }
        var peek = heap.peek();
        if( peek[1] > Math.ceil((s.length() + 1) / 2))
            return "";
        StringBuilder sb = new StringBuilder();
        while(!heap.isEmpty()) {
            var first = heap.poll();
            if(sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char)first[0]);
                if(--first[1] > 0)
                    heap.add(first);
            } else {
                if(heap.isEmpty())
                    return "";
                var second = heap.poll();
                sb.append((char)second[0]);
                if(--second[1] > 0)
                    heap.add(second);
                heap.add(first);
            }
        }
        return sb.toString();
    }
}
