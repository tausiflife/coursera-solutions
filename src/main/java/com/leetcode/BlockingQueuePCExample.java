package com.leetcode;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueuePCExample {

    public static void main(String[] args) {

        BlockingQueue<String> queue=new ArrayBlockingQueue<>(5);
        Producer producer=new Producer(queue);
        Consumer consumer=new Consumer(queue);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

    }

    static class Producer implements Runnable {

        BlockingQueue<String> queue=null;

        public Producer(BlockingQueue queue) {
            super();
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Producing element 1");
                    queue.put("Element 1");
                    System.out.println("Producing element 2");
                    queue.put("Element 2");
                    System.out.println("Producing element 3");
                    queue.put("Element 3");
                    System.out.println("Producing element 4");
                    queue.put("Element 4");
                    System.out.println("Producing element 5");
                    queue.put("Element 5");
                    System.out.println("Producing element 6");
                    queue.put("Element 6");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        BlockingQueue<String> queue=null;

        public Consumer(BlockingQueue queue) {
            super();
            this.queue = queue;
        }

        @Override
        public void run() {

            while(true)
            {
                try {
                    System.out.println("Consumed "+queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
