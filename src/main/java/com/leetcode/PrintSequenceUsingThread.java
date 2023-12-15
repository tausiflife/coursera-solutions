package com.leetcode;

import com.ooad.ticketbookingsystem.model.Theatre;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintSequenceUsingThread {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger(1);
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (count) {
                    try {
                        if(count.get() % 3 != 0) {
                            count.notifyAll();
                            count.wait();
                        }
                        if (count.get() % 3 == 0) {
                            System.out.println(Thread.currentThread().getName()+" "+count);
                            count.getAndIncrement();
                        }
                        count.notifyAll();
                        Thread.sleep(1);
                    }catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "T3");
        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (count) {
                    try {
                        if(count.get() % 3 != 1) {
                            count.notifyAll();
                            count.wait();
                        }
                        if (count.get() % 3 == 1) {
                            System.out.println(Thread.currentThread().getName()+" "+count);
                            count.getAndIncrement();
                        }
                        count.notifyAll();
                        Thread.sleep(1);
                    }catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "T1");
        Thread t3 = new Thread(() -> {
            while (true) {
                synchronized (count) {
                    try {
                        if(count.get() % 3 != 2) {
                            count.notifyAll();
                            count.wait();
                        }
                        if (count.get() % 3 == 2) {
                            System.out.println(Thread.currentThread().getName()+" "+count);
                            count.getAndIncrement();
                        }
                        count.notifyAll();
                        Thread.sleep(1);
                    }catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "T2");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
