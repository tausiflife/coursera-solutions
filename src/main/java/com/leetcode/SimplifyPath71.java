package com.leetcode;

import com.algo1.weeks.Stack;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.Collectors;

public class SimplifyPath71 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/d/e/e/"));
    }

    public static String simplifyPath(String path) {
        String[] dirs = path.split("/");
        ArrayDeque<String> queue = new ArrayDeque<>();
        int n = dirs.length;
        for(int i=0; i<n; i++) {
            String dir= dirs[i];
            if(dir.equals(".") || "".equals(dir))
                continue;
            else if(dir.equals("..")) {
                if(!queue.isEmpty())
                    queue.pollLast();
            } else {
                queue.offerLast(dir);
            }
        }
        String out = queue.stream().collect(Collectors.joining("/", "/", ""));
        return out;
    }
}
