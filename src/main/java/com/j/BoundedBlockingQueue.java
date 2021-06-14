package com.j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {
    private ReentrantLock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();
    private int[] queue;
    private int tail = 0;
    private int head = 0;
    private int size = 0;

    public BoundedBlockingQueue(int capacity) {
        queue = new int[capacity];
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (size == queue.length) {
                System.out.println("Full");
                full.await();
            }
            System.out.println("Enqueuing " + element);
            queue[tail++] = element;
            tail %= queue.length;
            size++;
            empty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            if (size == 0) {
                System.out.println("Empty");
                empty.await();
            }
            int element = queue[head++];
            System.out.println("Dequeuing " + element);
            head %= queue.length;
            size--;
            full.signal();
            return element;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return this.size;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BoundedBlockingQueue queue = new BoundedBlockingQueue(2);
        Thread t1 = new Thread(() -> {
            int i = 0;
            while (i++ < 5) {
                try {
                    queue.enqueue(i);
                    Thread.sleep((long) (Math.random() * 100L));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            int i = 0;
            while (i++ < 5) {
                try {
                    System.out.println(Thread.currentThread().getName() + " dequeued " + queue.dequeue());
                    Thread.sleep((long) (Math.random() * 150L));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
