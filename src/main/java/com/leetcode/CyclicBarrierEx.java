package com.leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierEx {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, ()-> {
            System.out.println("All reached !");
        });
        Thread t1 = new Thread(()->{
            waiting(cyclicBarrier, 1000);
        });
        Thread t2 = new Thread(()->{
            waiting(cyclicBarrier, 1000);
        });
        Thread t3 = new Thread(()->{
            waiting(cyclicBarrier, 1000);
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
    static void waiting(CyclicBarrier barrier, int time) {
        try {
            Thread.sleep(time);
            barrier.await();
            System.out.println(Thread.currentThread().getName()+" after barrier await.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
