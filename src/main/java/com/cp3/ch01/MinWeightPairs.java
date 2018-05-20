package com.cp3.ch01;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * cp3 - ch01, introduction problem. (brute force)
 * given points in 2D plane - find the pairs(N number - N/2 pairs) where sum of all distances is minimum.
 * Created by Ankur on 20-05-2018.
 */
public class MinWeightPairs {

    private Map<SimpleEntry<Integer, Integer>, Double> distances = new HashMap<>();

    private Double calculateDistance(SimpleEntry<Integer, Integer> x1, SimpleEntry<Integer, Integer> x2) {
        return Math.sqrt(Math.pow(Double.valueOf(x1.getKey()) - Double.valueOf(x2.getKey()), 2)
                + Math.pow(Double.valueOf(x1.getValue()) - Double.valueOf(x2.getValue()), 2));
    }


    private void calculateAndUpdateDistance(Integer index,
                                            List<SimpleEntry<Integer, Integer>> points) {
        if (index < 0 || index > points.size()) {
            throw new IllegalArgumentException("invalid index");
        }
        for (int i = index + 1; i < points.size(); i++) {
            distances.put(new SimpleEntry<>(index, i), calculateDistance(points.get(index), points.get(i)));
        }
    }

    public double getMinCost(List<SimpleEntry<Integer, Integer>> points) {

        IntStream.range(0, points.size())
                .forEachOrdered(value -> calculateAndUpdateDistance(value, points));

        System.out.println(distances);

        return 0;
    }

}
