package com.leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWriterProblem {
    public static void main(String[] args) {
        CustomReadWriteWithoutUsingReentrantLock reader = new CustomReadWriteWithoutUsingReentrantLock();
        Thread t1 = new Thread(()-> {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() +" reading value = "+reader.getValue());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(()-> {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() +" reading value = "+reader.getValue());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        AtomicInteger i = new AtomicInteger(0);
        Thread t3 = new Thread(()-> {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() +" writing value");
                    reader.setValue(i.getAndIncrement());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}

class CustomReadWriteUsingReentrantLock {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();
    private int value;

    public int getValue() {
        readLock.lock();
        try {
            return value;
        } finally {
            readLock.unlock();
        }
    }

    public void setValue(int value) {
        writeLock.lock();
        try {
            this.value = value;
        } finally {
            writeLock.unlock();
        }
    }
}

class CustomReadWriteWithoutUsingReentrantLock {
    private Semaphore readLock = new Semaphore(3);
    private Semaphore writeLock = new Semaphore(1);
    private int value;

    public int getValue() {
        try {
            System.out.println(Thread.currentThread().getName() + " is acquiring read lock.");
            readLock.acquire();
            while (writeLock.availablePermits() == 0) {
                System.out.println("Writer is writing. Reader waits");
                Thread.sleep(100);
            }
            System.out.println("Reader read value " + value);
            return value;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setValue(int value) {
        try {
            System.out.println(Thread.currentThread().getName() + " is acquiring write lock.");
            writeLock.acquire();
            this.value = value;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(Thread.currentThread().getName() + " is releasing write lock.");
            writeLock.release();
        }
    }
}
