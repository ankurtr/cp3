package com.j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

/**
 * Created by ankur on 11/4/17.
 */
public class ArrayDequeTest {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        //stack
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        System.out.println(deque);

        deque = new ArrayDeque<>();
        //queue
        deque.addFirst(1);
        deque.add(2);
        deque.add(3);

        System.out.println(deque);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 3);
        map.put(1, 2);
        System.out.println(map);

    }
}
