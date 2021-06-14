package com.j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

class DilRaju {
    String newRaju;
    String oldRaju;

    public DilRaju(String newRaju, String oldRaju) {
        this.newRaju = newRaju;
        this.oldRaju = oldRaju;
    }

    public String getNewRaju() {
        return newRaju;
    }

    public void setNewRaju(String newRaju) {
        this.newRaju = newRaju;
    }

    public String getOldRaju() {
        return oldRaju;
    }

    public void setOldRaju(String oldRaju) {
        this.oldRaju = oldRaju;
    }

    @Override
    public String toString() {
        return "DilRaju{" +
                "newRaju='" + newRaju + '\'' +
                ", oldRaju='" + oldRaju + '\'' +
                '}';
    }
}

public class CopyOnWriteArrayListTest {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("ankur");
        list.add("anil");
        list.add("chandni");
        list.add("jalpa");

        String s = new String("Blah");
        list.add(s);
        CopyOnWriteArrayList<String> list2 = (CopyOnWriteArrayList<String>) list.clone();

        ArrayList<DilRaju> list3 = new ArrayList<>();

        DilRaju d1 = new DilRaju("1", "2");
        DilRaju d2 = new DilRaju("3", "4");
        DilRaju d3 = new DilRaju("5", "6");

        list3.add(d1);
        list3.add(d2);
        list3.add(d3);

        System.out.println("list2" + list3);

        ArrayList<DilRaju> list4 = (ArrayList<DilRaju>) list3.clone();

        Thread t1 = new Thread(() -> {
            Iterator<DilRaju> iterator = list3.iterator();
            while (iterator.hasNext()) {
                iterator.next().setNewRaju(Thread.currentThread().getName());
                /*try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        });

        Thread t2 = new Thread(() -> {
            IntStream.range(0, list3.size())
                    .forEach(idx -> {
                        if (idx % 2 == 0) {
                            list3.remove(idx);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        });

        t1.start();
        //t2.start();

        t1.join();
        System.out.println(list3);
        System.out.println(list4);


        /*list.forEach(name -> {
            System.out.println(name);
            if (name.startsWith("a")) {
                list.remove(name);
            }
        });*/

        //System.out.println(list);
    }
}
