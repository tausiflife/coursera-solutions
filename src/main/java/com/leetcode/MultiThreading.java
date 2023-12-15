package com.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreading {
    //Two threads should print value as t1 prints 1, and t2 prints 2..
    public static void main(String[] args) throws InterruptedException {
        printOddEvenValues();
    }

    public static void twoThreadsIncrementSharedCounter() {

    }
    public static void printOddEvenValues() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(1);
        Runnable odd = () -> {
            while (true) {
                synchronized (counter) {
                    try {
                        if(counter.get() % 2 == 0) {
                            System.out.println("Odd thread "+Thread.currentThread().getName()+" released lock and " +
                                    "now waiting");
                            counter.wait();
                            System.out.println("Odd thread "+Thread.currentThread().getName()+" after wait");
                        }
                        if(counter.get() % 2 != 0) {
                            System.out.println("Odd thread " + Thread.currentThread().getName() + " produced value " + counter.getAndIncrement());
                            counter.notifyAll();
                            Thread.sleep(100);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Runnable even = () -> {
            while (true) {
                synchronized (counter) {
                    try {
                        if (counter.get() % 2 != 0) {
                            //our condition is not satisfied, so release lock on this object
                            //and then wait here
                            System.out.println("Even thread "+Thread.currentThread().getName()+" released lock and " +
                                    "now waiting");
                            counter.wait();
                            System.out.println("Even thread "+Thread.currentThread().getName()+" after wait");
                        }
                        if (counter.get() % 2 == 0) {
                            System.out.println("Even thread " + Thread.currentThread().getName() + " produced value " + counter.getAndIncrement());
                            counter.notifyAll();
                            Thread.sleep(100);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        };
        Thread t1= new Thread(odd, "odd-0");
        Thread t2 = new Thread(even, "even-0");
        Thread t3= new Thread(odd, "odd-1");
        Thread t4 = new Thread(even, "even-1");
        t1.start();;
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}
