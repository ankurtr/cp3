package com.j;

import java.util.ArrayDeque;

@SuppressWarnings("ALL")
public class PayTm {

    private ArrayDeque<Integer> deque;
    //private ArrayList<Integer> list;
    private int size = 0;
    private int windowSum = 0;
    private int count = 0;

    public PayTm(int size) {
        this.size = size;
        deque = new ArrayDeque<>();
        //list = new ArrayList<>();
    }

    public static void main(String[] args) {
        PayTm p = new PayTm(3);
        System.out.println(p.movingAverage(1));
        System.out.println(p.movingAverage(10));
        System.out.println(p.movingAverage(3));
        System.out.println(p.movingAverage(5));

        System.out.println(p.deque);
    }

    public double movingAverage(int val) {
        ++count;
        deque.add(val);
        int tail = (count <= size) ? 0 : deque.peek();
        windowSum = windowSum - tail + val;

        return windowSum * 1.0 / Math.min(count, size);
    }

    /*public double movingAverage1(int val) {
        list.add(val);

        int sum = 0;
        for (int i = Math.max(0, list.size() - size); i < list.size(); i++) {
            sum += list.get(i);
        }

        return sum * 1.0 / Math.min(list.size(), size);
    }*/
}
