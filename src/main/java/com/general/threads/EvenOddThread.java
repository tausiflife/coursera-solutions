package com.general.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class EvenOddThread {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger lock = new AtomicInteger(1);
        OddThread odd = new OddThread(lock);
        EvenThread even = new EvenThread(lock);
        odd.start();
        even.start();
        odd.join();
        even.join();
    }
}
class OddThread extends Thread {
    AtomicInteger lock;
    public OddThread(AtomicInteger lock) {
        this.lock = lock;

    }


    public void run() {
        while(true) {
            synchronized(lock) {
                try {
                    System.out.println("odd value" + lock.getAndIncrement());
                    lock.notify();
                    Thread.sleep(3000);
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class EvenThread extends Thread {
    AtomicInteger lock;
    public EvenThread(AtomicInteger lock) {
        this.lock = lock;
    }

    public void run() {
        while(true) {
            synchronized(lock) {
                try {
                    System.out.println("even value" + lock.getAndIncrement());
                    Thread.sleep(3000);
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
