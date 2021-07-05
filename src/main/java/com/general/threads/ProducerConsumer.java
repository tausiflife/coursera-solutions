package com.general.threads;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {
    private List<Integer> list = new ArrayList<>();
    private int capacity = 2;
    private Object lock;

    public ProducerConsumer(Object lock) {
        this.lock = lock;
    }

    public void produce() throws InterruptedException {
        int val = 0;
        while (true) {
            synchronized (lock) {
                System.out.println("Producer has produced a value");
                lock.notify();
                Thread.sleep(3000);
                lock.wait();
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                System.out.println("Consumer has consumed a value");
                lock.notify();
                Thread.sleep(3000);
                lock.wait();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, SQLException {
        Object lock = new Object();
        Thread ping = new Thread(new Producer(lock));
        Thread pong = new Thread(new Consumer(lock));
        ping.start();
        pong.start();
        ping.join();
        pong.join();
    }
}

class Producer implements Runnable {

    private Object lock;
    int count = 2;

    public Producer(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println("Inside producer");
                lock.notify();
                System.out.println("Producer called notify");
                //Thread.sleep(3000);
                lock.wait();
                System.out.println("Producer waking up from sleep");
                lock.notify();
                System.out.println("Producer called notify");
                //Thread.sleep(3000);
                lock.wait();
                System.out.println("Producer going to sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {

    private Object lock;
    int count = 2;

    public Consumer(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println("Inside consumer");
                lock.notify();
                System.out.println("Consumer called notify");
                //Thread.sleep(3000);
                lock.wait();
                System.out.println("Consumer waking up from sleep");
                lock.notify();
                System.out.println("Consumer called notify");
                //Thread.sleep(3000);
                lock.wait();
                System.out.println("Consumer waking up from sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
