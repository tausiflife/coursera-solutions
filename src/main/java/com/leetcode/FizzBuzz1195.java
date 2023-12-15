package com.leetcode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class FizzBuzz1195 {
    private int n;
    private Lock lock;
    private int currentNumber;
    public FizzBuzz1195(int n) {
        this.n = n;
        this.lock = new ReentrantLock();
        currentNumber = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (currentNumber <=n) {
            try {
                lock.lock();
                if(currentNumber <=n && currentNumber % 3 == 0 && currentNumber % 5 != 0) {
                    printFizz.run();
                    currentNumber += 1;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (currentNumber <=n) {
            try {
                lock.lock();
                if(currentNumber <=n && currentNumber % 3 != 0 && currentNumber % 5 == 0) {
                    printBuzz.run();
                    currentNumber += 1;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (currentNumber <=n) {
            try {
                lock.lock();
                if(currentNumber <=n && currentNumber % 3 == 0 && currentNumber % 5 == 0) {
                    printFizzBuzz.run();
                    currentNumber += 1;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (currentNumber <=n) {
            try {
                lock.lock();
                if(currentNumber <=n && currentNumber % 3 != 0 && currentNumber % 5 != 0) {
                    printNumber.accept(currentNumber);
                    currentNumber += 1;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FizzBuzz1195 fizzBuzz1195 = new FizzBuzz1195(15);
        Runnable fizz = ()-> System.out.println("fizz");
        Runnable buzz = ()-> System.out.println("buzz");
        Runnable fizzbuzz = ()-> System.out.println("fizzbuzz");
        Thread a = new Thread(() -> {
            try {
                fizzBuzz1195.fizz(fizz);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread b = new Thread(() -> {
            try {
                fizzBuzz1195.buzz(buzz);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread c = new Thread(() -> {
            try {
                fizzBuzz1195.fizzbuzz(fizzbuzz);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread d = new Thread(() -> {
            try {
                fizzBuzz1195.number((num) -> {
                    System.out.println(num);
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        a.start();
        b.start();
        c.start();
        d.start();

        a.join();
        b.join();
        c.join();
        d.join();
    }
}
