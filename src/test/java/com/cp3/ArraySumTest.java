package com.cp3;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ankur on 26/3/17.
 */
public class ArraySumTest {

    @Test
    public void isSumPresent() {
        Assert.assertEquals(true, ArraySum.isSumPresent(new int[]{1, 4, 45, 6, 10, 8}, 16));
        Assert.assertEquals(false, ArraySum.isSumPresent(new int[]{1, 4, 45, 6, 10, 8}, 22));
    }

    @Test
    public void isSumPresent_() {
        Assert.assertEquals(true, ArraySum.isSumPresent_(new int[]{1, 4, 45, 6, 10, 8}, 16));
        Assert.assertEquals(false, ArraySum.isSumPresent_(new int[]{1, 4, 45, 6, 10, 8}, 22));
    }
}