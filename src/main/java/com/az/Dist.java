package com.az;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class PairInt {
    int first;
    int second;

    public PairInt(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "PairInt{" +
                "x=" + first +
                ", y=" + second +
                '}';
    }
}

public class Dist {
    public static void main(String[] args) {
        Dist d = new Dist();
        List<PairInt> allocations = new ArrayList<>();
        allocations.add(new PairInt(1, 2));
        allocations.add(new PairInt(3, 4));
        allocations.add(new PairInt(1, -1));
        System.out.println(d.closestLocations(3, allocations, 2));
    }

    List<PairInt> closestLocations(int totalCrates,
                                   List<PairInt> allLocations,
                                   int truckCapacity) {
        if (truckCapacity <= 0 || allLocations.size() != totalCrates) {
            return new ArrayList<>();
        }
        Comparator<PairInt> comparator = Comparator.comparingDouble(o -> ((o.first * o.first) + (o.second * o.second)));
        //A min heap will consist of all the nearest locations
         PriorityQueue<PairInt> minHeap = new PriorityQueue<>(truckCapacity, comparator.reversed());

        allLocations.forEach(allocation -> {
            minHeap.add(allocation);
            if (minHeap.size() > truckCapacity) {
                minHeap.poll();
            }

        });

        return new ArrayList<>(minHeap);
    }
    // METHOD SIGNATURE ENDS

    private double getDistance(PairInt pair) {
        int sum = (pair.first * pair.first) + (pair.second * pair.second);
        return Math.sqrt(sum);
    }
}
