package com.paytm;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class MovingAverageDequeImpl implements MovingAverageDeque<Integer> {
    private int currentTotalElements = 0;
    private int windowSum = 0;
    private final int windowSize;
    private final ArrayDeque<Integer> deque = new ArrayDeque<>();

    public MovingAverageDequeImpl(int windowSize) {
        if(windowSize<0) {
            throw new IllegalArgumentException("Window size must be greater than 0");
        }
        this.windowSize = windowSize;
    }

    @Override
    public void addElement(Integer element) {
        if (element == null) {
            return;
        }
        currentTotalElements++;
        deque.add(element);

        int first = (currentTotalElements <= windowSize) ? 0 : deque.peek();

        windowSum = windowSum - first + element;
    }

    @Override
    public Double getMovingAverage() {
        if (currentTotalElements != 0 && deque.size() > 0) {
            return 1.0 * windowSum / Math.min(deque.size(), windowSize);
        }
        return 0.0;
    }

    @Override
    public ArrayList<Integer> getAllElements() {
        return new ArrayList<>(deque);
    }
}
