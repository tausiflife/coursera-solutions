package com.leetcode;

public class DeadLock {

    public static void main(String[] args) throws InterruptedException {
        Object shared1 = new Object();
        Object shared2 = new Object();
        Runnable run1 = () -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "acquiring shared 1 lock");
                synchronized (shared1) {
                    System.out.println(Thread.currentThread().getName() + "got shared 1 lock");
                    work();
                    System.out.println(Thread.currentThread().getName() + "acquiring shared 2 lock");
                    synchronized (shared2) {
                        System.out.println(Thread.currentThread().getName() + "got shared 2 lock");
                        work();
                    }
                }
            }
        };
        Runnable run2 = () -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "acquiring shared 2 lock");
                synchronized (shared2) {
                    System.out.println(Thread.currentThread().getName() + "got shared 2 lock");
                    work();
                    System.out.println(Thread.currentThread().getName() + "acquiring shared 1 lock");
                    synchronized (shared1) {
                        System.out.println(Thread.currentThread().getName() + "got shared 1 lock");
                        work();
                    }
                }
            }
        };
        Thread t1= new Thread(run1);
        Thread t2 = new Thread(run2);
        t1.start();
        work();
        t2.start();
        work();
    }

    private static void work() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
    }
}
