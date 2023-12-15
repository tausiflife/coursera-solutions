package com.leetcode;

public class MultiThreadingMultipleMethod {

    public static void main(String[] args) throws InterruptedException {
        Shared s = new Shared();
        Thread t1= new Thread(() -> {
                s.m1();
        });
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " accessing m2");
                s.m2();
        });
        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() +" accessing m2");
                s.m2();
        });
        Thread t4 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " accessing m3");
                s.m3();
        });
        Thread t5 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " accessing m3");
                s.m3();
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t3.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("Finished");
    }
}

