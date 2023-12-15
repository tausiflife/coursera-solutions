package com.leetcode;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();
        Random random = new Random();
        Runnable producer = () -> {
          while (true) {
              synchronized (queue) {
                  try {
                      if(queue.size() == 2) {
                          System.out.println("Queue is full "+Thread.currentThread().getName());
                          queue.notifyAll();
                          queue.wait();
                      }
                      if (queue.size() != 2){
                          int val = random.nextInt(100);
                          System.out.println("Produced "+val+" by "+Thread.currentThread().getName());
                          queue.add(val);
                      }
                      queue.notifyAll();
                      Thread.sleep(1000);
                  } catch (Exception e) {

                  }
              }
          }
        };

        Runnable consumer = () -> {
            while (true) {
                synchronized (queue) {
                    try {
                        if(queue.isEmpty()) {
                            System.out.println("Queue is empty "+Thread.currentThread().getName());
                            queue.notifyAll();
                            queue.wait();
                        }
                        if (!queue.isEmpty()){
                            System.out.println("Consumed "+ queue.poll() + " by "+Thread.currentThread().getName());
                        }
                        queue.notifyAll();
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                }
            }
        };

        Thread t1= new Thread(producer);
        Thread t2 = new Thread(consumer);
        Thread t3= new Thread(producer);
        Thread t4 = new Thread(consumer);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}
