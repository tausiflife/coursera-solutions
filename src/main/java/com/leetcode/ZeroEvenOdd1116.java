package com.leetcode;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd1116 {
    private int n;
    private final Lock lock;
    private int currentValue;
    private boolean zeroToBePrinted;

    public ZeroEvenOdd1116(int n) {
        this.n = n;
        this.lock = new ReentrantLock();
        this.currentValue = 1;
        this.zeroToBePrinted = true;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (currentValue <= n) {
            lock.lock();
            if (currentValue <= n) {
                if (zeroToBePrinted) {
                    printNumber.accept(0);
                    zeroToBePrinted = !zeroToBePrinted;
                }
            }
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (currentValue <= n) {
            lock.lock();
            if (currentValue <= n) {
                if (currentValue % 2 == 0 && !zeroToBePrinted) {
                    printNumber.accept(currentValue);
                    currentValue +=1;
                    zeroToBePrinted = true;
                }
            }
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (currentValue <= n) {
            lock.lock();
            if (currentValue <= n) {
                if (currentValue % 2 != 0 && !zeroToBePrinted) {
                    printNumber.accept(currentValue);
                    currentValue +=1;
                    zeroToBePrinted = true;
                }
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd1116 zeroEvenOdd1116 = new ZeroEvenOdd1116(5);
        Thread a = new Thread(() -> {
            try {
                zeroEvenOdd1116.zero((num) -> System.out.println(num));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread b = new Thread(() -> {
            try {
                zeroEvenOdd1116.odd((num) -> System.out.println(num));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread c = new Thread(() -> {
            try {
                zeroEvenOdd1116.even((num) -> System.out.println(num));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        a.start();
        b.start();
        c.start();

        a.join();
        b.join();
        c.join();
    }
}
