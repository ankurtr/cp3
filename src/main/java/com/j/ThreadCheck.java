package com.j;

/**
 * Created by ankur on 4/4/17.
 */

class A extends Thread {

    public A(Runnable target) {
        super(target);
    }
}

class B implements Runnable {
    @Override
    public synchronized void run() {
        try {
            Thread.sleep(10000);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println(Thread.currentThread().getName());
    }
}

class C implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            try {
                System.out.println("Hey" + Thread.currentThread().getName());
                Thread.currentThread().sleep(10000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Hello World" + Thread.currentThread().getName());
    }
}

public class ThreadCheck {


    public static void main(String[] args) throws InterruptedException {
        /*B b = new B();
        A a = new A(b);
        A c = new A(b);
        a.start();
        c.start();
        System.out.println("Threads are running it looks");
        a.join();
        System.out.println("I was waiting for T1 to finish");
        c.join();
        System.out.println("I was waiting for T2 to finish");
*/
        C cc = new C();
        A d = new A(cc);
        A e = new A(cc);
        d.start();
        e.start();
    }
}
