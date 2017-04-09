package com.j;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ankur on 4/4/17.
 */
public class BlockingQueue {

    private List<Integer> queue = new LinkedList<>();
    private int limit = 10;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(Integer elem) throws InterruptedException {

        if (queue.size() == limit) {
            wait();
        }
        if (queue.size() == 0) {
            notifyAll();
        }
        queue.add(elem);
    }

    public synchronized int dequeue() throws InterruptedException {
        if (queue.size() == 0) {
            wait();
        }
        if (queue.size() == limit) {
            notifyAll();
        }
        return queue.remove(0);
    }

    @Override
    public String toString() {
        return "BlockingQueue{" +
                "queue=" + queue +
                '}';
    }
}
