package com.leetcode;

class SharedCounter {
    private int count = 1;  // Starting from 1

    public int getNext() {
        return count++;
    }

    public int get() {
        return count;
    }
}

class EvenNumberThread extends Thread {
    private SharedCounter counter;

    public EvenNumberThread(SharedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (counter) {
                try {
                    int number = counter.get();
                    if (number % 2 != 0) {
                        counter.wait();
                    }
                    if(number % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + counter.getNext());
                        counter.notifyAll();
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class OddNumberThread extends Thread {
    private SharedCounter counter;

    public OddNumberThread(SharedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (counter) {
                try {
                    int number = counter.get();
                    if (number % 2 == 0) {
                        counter.wait();
                    }
                    if(number % 2 !=0) {
                        System.out.println(Thread.currentThread().getName() + ": " + counter.getNext());
                        counter.notifyAll();
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class EvenOddPrintingWithWaitNotify {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();

        // Creating 2 threads for even numbers
        Thread evenThread1 = new EvenNumberThread(sharedCounter);
        Thread evenThread2 = new EvenNumberThread(sharedCounter);

        // Creating 2 threads for odd numbers
        Thread oddThread1 = new OddNumberThread(sharedCounter);
        Thread oddThread2 = new OddNumberThread(sharedCounter);

        // Naming the threads for better identification
        evenThread1.setName("Even Thread 1");
        evenThread2.setName("Even Thread 2");
        oddThread1.setName("Odd Thread 1");
        oddThread2.setName("Odd Thread 2");

        // Starting all the threads
        evenThread1.start();
        evenThread2.start();
        oddThread1.start();
        oddThread2.start();
    }
}


