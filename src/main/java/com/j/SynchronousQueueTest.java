package com.j;

import java.util.concurrent.SynchronousQueue;
import java.util.stream.IntStream;

class X extends Thread {
    private SynchronousQueue<Integer> queue;

    public X(SynchronousQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        do {
            System.out.println("Producing");
            IntStream.range(0, 10)
                    .forEach(index -> {
                        try {
                            queue.put(index);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
        } while (true);
    }
}

class Y extends Thread {
    private SynchronousQueue<Integer> queue;

    public Y(SynchronousQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println("Consuming -" + queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        Y consumer = new Y(queue);
        X producer = new X(queue);

        System.out.println("Starting Consumer");
        consumer.start();
        Thread.sleep(10000);

        System.out.println("Starting Producer");
        producer.start();
    }
}
