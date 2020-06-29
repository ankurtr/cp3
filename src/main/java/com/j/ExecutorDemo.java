package com.j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService singleThreadExecutor = Executors.newScheduledThreadPool(1);

        singleThreadExecutor.submit(() -> System.out.println("Thread" + Thread.currentThread().getName()));

        Thread.sleep(3000);
        System.out.println(singleThreadExecutor.isShutdown());
        System.out.println(singleThreadExecutor.isTerminated());
    }
}
