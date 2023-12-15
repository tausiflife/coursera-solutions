package com.leetcode;

public class SynchronizedExample {
    // Class-level lock
    public static synchronized void staticSyncMethod() {
        System.out.println("Static synchronized method start " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulating some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Static synchronized method end " + Thread.currentThread().getName());
    }

    // Object-level lock
    public synchronized void instanceSyncMethod() {
        System.out.println("Instance synchronized method start " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulating some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Instance synchronized method end " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        final SynchronizedExample instance1 = new SynchronizedExample();
        final SynchronizedExample instance2 = new SynchronizedExample();

        // Test case 1: Using class-level lock
        Thread thread1 = new Thread(() -> {
            SynchronizedExample.staticSyncMethod();
        });

        Thread thread2 = new Thread(() -> {
            SynchronizedExample.staticSyncMethod();
        });

        Thread thread3 = new Thread(() -> {
            instance1.instanceSyncMethod();
        });

        Thread thread4 = new Thread(() -> {
            instance2.instanceSyncMethod();
        });

        // Both threads will be able to run sequentially since the lock is at the class level.
        thread3.start();
        thread4.start();
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

