package com.general.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class TestCallableRunnable {
    @Test
    void testCallableRunnable() throws ExecutionException, InterruptedException {
        Runnable runnable = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future future = executor.submit(runnable);
        System.out.println(future.get());
        executor.shutdown();
    }

    @Test
    void concatenateTwoStringsUsingThreads() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Callable callable1 = () ->  {
            System.out.println(Thread.currentThread().getId());
            return "a";
        };
        Callable callable2 = () -> {
            System.out.println(Thread.currentThread().getId());
            Thread.sleep(5000);
            return "b";
        };
        Future<String> future1 = executorService.submit(callable1);
        Future<String> future2 = executorService.submit(callable2);
        StringBuilder builder = new StringBuilder();
        builder.append(future1.get()).append(" ").append(future2.get());
        System.out.println(builder.toString());
        executorService.shutdown();
    }
}
