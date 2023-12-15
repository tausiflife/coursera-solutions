package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CompletelyFutureConcepts  {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                t1.join();
                System.out.println("Thread 2");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                t2.join();
                System.out.println("Thread 3");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t2.start();
        t1.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }

    static Optional<String> getData(String s) {
        return Optional.of("1"+s);
    }
}
