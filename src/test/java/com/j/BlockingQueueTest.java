package com.j;

import org.junit.Test;

/**
 * Created by ankur on 4/4/17.
 */


class Producer implements Runnable {
    private final BlockingQueue producer;

    public Producer(BlockingQueue producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true) {
            Double randomNum = Math.random() * 100;
            try {
                producer.enqueue(randomNum.intValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Enqueued : " + randomNum);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue consumer;

    public Consumer(BlockingQueue consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true) {
            Double randomNum = Math.random() * 100;
            try {
                System.out.println("Dequeued : " + consumer.dequeue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class BlockingQueueTest {

    @Test
    public void testBlockingQueue() {
        BlockingQueue queue = new BlockingQueue(10);
        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();

        try {
            Thread.currentThread().sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}