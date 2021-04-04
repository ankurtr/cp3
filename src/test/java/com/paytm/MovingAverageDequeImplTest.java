package com.paytm;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MovingAverageDequeImplTest extends TestCase {

    private MovingAverageDeque<Integer> movingAverageDeque;

    /*@Test(expected = IllegalArgumentException.class)
    public void testAddNullElement() {
        new MovingSumDequeImpl(3).addElement(null);
    }*/

    @Test
    public void testGetMovingAverage() {
        int N = 3;
        Double movingAverage;
        movingAverageDeque = new MovingAverageDequeImpl(3);
        movingAverageDeque.addElement(1);
        movingAverage = movingAverageDeque.getMovingAverage();
        Assert.assertEquals(1.0d, movingAverage, 0.0);

        movingAverageDeque.addElement(10);
        movingAverage = movingAverageDeque.getMovingAverage();
        Assert.assertEquals(5.5, movingAverage, 0.0);

        movingAverageDeque.addElement(3);
        movingAverage = movingAverageDeque.getMovingAverage();
        Assert.assertEquals(4.666666666666667, movingAverage, 0.0);

        movingAverageDeque.addElement(5);
        movingAverage = movingAverageDeque.getMovingAverage();
        Assert.assertEquals(6.0, movingAverage, 0.0);
    }

    @Test
    public void testGetAllElements() {
        movingAverageDeque = new MovingAverageDequeImpl(3);
        movingAverageDeque.addElement(1);
        movingAverageDeque.addElement(2);
        movingAverageDeque.addElement(3);
        movingAverageDeque.addElement(4);

        List<Integer> allElements = movingAverageDeque.getAllElements();
        List<Integer> expectedElements = new ArrayList<>();
        IntStream.range(0, 4)
                .forEach(index -> expectedElements.add(index + 1));

        Assert.assertTrue(allElements.containsAll(expectedElements));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWindowSize() {
        new MovingAverageDequeImpl(-1);
    }
}