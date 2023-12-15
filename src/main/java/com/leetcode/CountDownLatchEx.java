package com.leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CountDownLatchEx {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread t1 = new Thread(()->{
            waiting(countDownLatch, 1000);
        });
        Thread t2 = new Thread(()->{
            waiting(countDownLatch, 1000);
        });
        Thread t3 = new Thread(()->{
            waiting(countDownLatch, 1000);
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Before await");
        countDownLatch.await();
        System.out.println("after await");
    }
    static void waiting(CountDownLatch latch, int time) {
        try {
            Thread.sleep(time);
            latch.countDown();
            System.out.println(Thread.currentThread().getName()+" after barrier await.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
