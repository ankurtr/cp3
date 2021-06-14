package com.j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Worker implements Runnable {

    private int id;


    public Worker(int id, Object lock1, Object lock2) {
        this.id = id;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    private Random random = new Random();
    private final Object lock1;
    private final Object lock2;

    public void stageOne() {

        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }

            ExecutorServicePasteBin.list1.add(random.nextInt(100));

        }

    }

    public void stageTwo() {

        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }

            ExecutorServicePasteBin.list2.add(random.nextInt(100));
        }

    }

    public void process() {
        for (int i = 0; i < 500; i++) {
            stageOne();
            stageTwo();
        }
    }

    @Override
    public void run() {
        System.out.println("Starting thread: " + id);
        process();
        System.out.println("Completed: " + id);
    }

}

public class ExecutorServicePasteBin {

    public static List<Integer> list1 = new ArrayList<>();
    public static List<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Object lock1 = new Object();
        Object lock2 = new Object();
        for (int j = 0; j < 2; j++) {
            executor.submit(new Worker(j, lock1, lock2));
        }

        executor.shutdown();
        System.out.println("All tasks submitted: ");

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {

        }
        long end = System.currentTimeMillis();

        System.out.println("Time taken: " + (end - start));
        System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
    }

}