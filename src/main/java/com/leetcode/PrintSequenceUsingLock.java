package com.leetcode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintSequenceUsingLock {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger(1);
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            while (true) {
                printAndIncrement(count, lock, 0);
            }
        }, "T3");
        Thread t2 = new Thread(() -> {
            while (true) {
                printAndIncrement(count, lock, 1);
            }
        }, "T1");
        Thread t3 = new Thread(() -> {
            while (true) {
                printAndIncrement(count, lock, 2);
            }
        }, "T2");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }

    private static void printAndIncrement(AtomicInteger count, Lock lock, int number) {
        try {
            lock.lock();
            if (count.get() % 3 == number) {
                System.out.println(Thread.currentThread().getName()+" "+count);
                count.getAndIncrement();
            }
            lock.unlock();
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
