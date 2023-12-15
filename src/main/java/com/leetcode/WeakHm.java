package com.leetcode;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.stream.Stream;

public class WeakHm {
    public static void main(String[] args) {
        Map<User, Integer> map = new WeakHashMap<>();
        Stream.iterate(1, (t) -> t+1).limit(10).forEach( t-> {
            map.put(new User("User"+t), t);
        });
        System.out.println(map.size());
        System.gc();
        System.out.println(map.size());
    }
}
class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}
