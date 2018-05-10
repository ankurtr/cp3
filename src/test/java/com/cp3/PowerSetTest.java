package com.cp3;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by ankur on 31/3/18.
 */
public class PowerSetTest {
    @Test
    public void generatePowerSet() throws Exception {
        List<String> list = new ArrayList<>();
        Set<String> result = new PowerSet().powerSet(list);
        Assert.assertNotNull(result);
    }

    @Test
    public void generatePowerSet2() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("C");
        Set<String> result = new PowerSet().powerSet(list);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.size() == Math.pow(2, list.size()));
    }

    @Test
    public void testSomething() {
        System.out.println(1 << 2);
        System.out.println((1 << 2) & 5);
        System.out.println(5 & 1);
    }

    @Test
    public void testSetBitsInGivenNumber() {
        assertEquals(getSetBit(3), 2);
        assertEquals(getSetBit(5), 2);
        assertEquals(getSetBit(7), 3);
    }

    private int getSetBit(int n) {
        int c = 0;
        while (n > 0) {
            n &= n - 1;
            c++;
        }
        return c;
    }

}