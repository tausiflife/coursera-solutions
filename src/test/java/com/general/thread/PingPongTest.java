package com.general.thread;

import com.general.threads.PingPongThread;
import org.junit.jupiter.api.Test;

public class PingPongTest {

    @Test
    public void testPingPong() throws InterruptedException {
        Object lock = new Object();
        Thread ping = new Thread(new PingPongThread(lock, "ping"));
        Thread pong = new Thread(new PingPongThread(lock, "pong"));
        ping.start();
        pong.start();
        ping.join();
        pong.join();
    }
}
