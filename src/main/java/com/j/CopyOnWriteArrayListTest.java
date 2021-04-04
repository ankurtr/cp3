package com.j;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("ankur");
        list.add("anil");
        list.add("chandni");
        list.add("jalpa");

        list.forEach(name -> {
            System.out.println(name);
            if (name.startsWith("a")) {
                list.remove(name);
            }
        });

        System.out.println(list);
    }
}
