package com.general.threads;

public class PingPongThread implements Runnable{
    private Object lock;
    private String name;

    public PingPongThread(Object lock, String name) {
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
        synchronized (lock) {
                System.out.println(name);
                lock.notify();
                try {
                    Thread.sleep(3000);
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Thread ping = new Thread(new PingPongThread(lock, "ping"));
        Thread pong = new Thread(new PingPongThread(lock, "pong"));
        ping.start();
        pong.start();
    }
}
