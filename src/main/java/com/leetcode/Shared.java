package com.leetcode;

public class Shared {
    public void m1() {
        try {
            System.out.println(Thread.currentThread().getName() + ": m1");
            System.out.println(Thread.currentThread().getName() + " sleeping");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void m2() {
        try {
            System.out.println(Thread.currentThread().getName() + ": m2");
            System.out.println(Thread.currentThread().getName() + " sleeping");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static synchronized void m3() {
        try {
            System.out.println(Thread.currentThread().getName() + ": m3");
            System.out.println(Thread.currentThread().getName() + " sleeping");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
