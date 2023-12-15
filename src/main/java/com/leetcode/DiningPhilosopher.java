package com.leetcode;

import java.util.concurrent.Semaphore;

public class DiningPhilosopher {
    public static void main(String[] args) {
        //create number of philosopher
        final int NO_OF_PHILOSOPHERS = 5;
        Thread[] philosophers = new Thread[NO_OF_PHILOSOPHERS];
        //Semaphores for each fork
        Semaphore[] forks = new Semaphore[NO_OF_PHILOSOPHERS];
        for (int i =0;i< NO_OF_PHILOSOPHERS; i++) {
            forks[i] = new Semaphore(1);
        }
        for (int i =0;i< NO_OF_PHILOSOPHERS; i++) {
            philosophers[i] = new Thread(new Philosopher(i));
            philosophers[i].start();
        }

    }
}
class Philosopher implements Runnable {
    private int id;

    public Philosopher(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
            }
        } catch (Exception e) {

        }
    }

    private void think() {
        System.out.println("Philosopher "+ id + " is thinking...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void eat() {
        System.out.println("Philosopher "+ id + " is eating...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
