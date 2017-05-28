package com.di.sd17;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ankur on 20/5/17.
 */
public class CobraTempleTest {
    @Test
    public void buildTemple1() throws Exception {
        Assert.assertTrue(CobraTemple.buildTemple1(new int[]{1, 2, 3, 2, 1}));
        Assert.assertFalse(CobraTemple.buildTemple1(new int[]{2, 3, 4, 5, 4, 3, 2}));
        Assert.assertFalse(CobraTemple.buildTemple1(new int[]{1, 2, 3, 4, 3}));
        Assert.assertFalse(CobraTemple.buildTemple1(new int[]{1, 3, 5, 3, 1}));
        Assert.assertTrue(CobraTemple.buildTemple1(new int[]{1, 2, 3, 4, 3, 2, 1}));
        Assert.assertFalse(CobraTemple.buildTemple1(new int[]{1, 2, 3, 2}));
        Assert.assertFalse(CobraTemple.buildTemple1(new int[]{1, 2, 2, 1}));

    }

    @Test
    public void buildTemple() throws Exception {
        Assert.assertTrue(CobraTemple.buildTemple(new int[]{1, 2, 3, 2, 1}));
        Assert.assertFalse(CobraTemple.buildTemple(new int[]{2, 3, 4, 5, 4, 3, 2}));
        Assert.assertFalse(CobraTemple.buildTemple(new int[]{1, 2, 3, 4, 3}));
        Assert.assertFalse(CobraTemple.buildTemple(new int[]{1, 3, 5, 3, 1}));
        Assert.assertTrue(CobraTemple.buildTemple(new int[]{1, 2, 3, 4, 3, 2, 1}));
        Assert.assertFalse(CobraTemple.buildTemple(new int[]{1, 2, 3, 2}));
        Assert.assertFalse(CobraTemple.buildTemple(new int[]{1, 2, 2, 1}));

    }

    @Test
    public void checkTemple() throws Exception {
        Assert.assertEquals(1, CobraTemple.checkTemple(new int[]{1, 2, 4, 2, 1}));
        Assert.assertEquals(7, CobraTemple.checkTemple(new int[]{2, 3, 4, 5, 4, 3, 2}));
        Assert.assertEquals(4, CobraTemple.checkTemple(new int[]{1, 2, 3, 4, 3}));
        Assert.assertEquals(4, CobraTemple.checkTemple(new int[]{1, 3, 5, 3, 1}));
        Assert.assertEquals(0, CobraTemple.checkTemple(new int[]{1, 2, 3, 4, 3, 2, 1}));
        Assert.assertEquals(3, CobraTemple.checkTemple(new int[]{1, 2, 3, 2}));
        Assert.assertEquals(2, CobraTemple.checkTemple(new int[]{1, 2, 2, 1}));
        Assert.assertEquals(0, CobraTemple.checkTemple(new int[]{1, 2, 1}));
        Assert.assertEquals(1, CobraTemple.checkTemple(new int[]{1, 1, 2, 1}));
        Assert.assertEquals(3, CobraTemple.checkTemple(new int[]{1, 2, 6, 2, 1}));
        Assert.assertEquals(3, CobraTemple.checkTemple(new int[]{2, 2, 2, 2, 2, 1}));

    }
}