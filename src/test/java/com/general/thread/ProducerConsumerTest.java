package com.general.thread;

import com.general.threads.ProducerConsumer;
import org.junit.jupiter.api.Test;


public class ProducerConsumerTest {

    @Test
    public void testProducerConsumer() throws InterruptedException {
        int numberOfThreads = 2;
        Object lock = new Object();
        ProducerConsumer producerConsumer = new ProducerConsumer(lock);

        Thread t1 = new Thread(() -> {
            try {
                producerConsumer.produce();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                producerConsumer.consume();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
