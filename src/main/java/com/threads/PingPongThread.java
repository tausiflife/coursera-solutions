package com.threads;

public class PingPongThread implements Runnable{
    private Object lock;
    private String name;

    public PingPongThread(Object lock, String name) {
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (true) {
                System.out.println(name);
                lock.notify();
                try {
                    Thread.sleep(30);
                    lock.wait(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
