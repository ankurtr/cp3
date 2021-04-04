package com.cp3.ch01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ankur on 20-05-2018.
 */
public class MinWeightXorPairsTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getMinCost() throws Exception {
        List<AbstractMap.SimpleEntry<Integer, Integer>> points = new ArrayList<>();
        points.add(0, new AbstractMap.SimpleEntry<Integer, Integer>(1, 1));
        points.add(1, new AbstractMap.SimpleEntry<Integer, Integer>(8, 6));
        points.add(2, new AbstractMap.SimpleEntry<Integer, Integer>(6, 8));
        points.add(3, new AbstractMap.SimpleEntry<Integer, Integer>(1, 3));
        assertEquals(0, new MinWeightPairs().getMinCost(points), 0);
    }

}