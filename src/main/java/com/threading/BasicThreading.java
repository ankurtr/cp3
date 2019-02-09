package com.threading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by trapaank on 05/05/18.
 */
public class BasicThreading implements Runnable {

    AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(incrementAndGet());
            System.out.println(atomicInteger.accumulateAndGet(10, (n, m) -> n + m));
        }
    }

    public synchronized int incrementAndGet() {
        return atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) {
        Thread t = new Thread(new BasicThreading());
        t.start();
    }
}
