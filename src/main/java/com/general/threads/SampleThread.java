package com.general.threads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SampleThread extends Thread {

    private Object lock = new Object();

    @Override
    public void run() {
        System.out.println("Sample thread id : " + Thread.currentThread().getId());
        try {
            synchronized (lock) {
                lock.wait(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new SampleThread());
        t.start();
        t.interrupt();
    }
}
