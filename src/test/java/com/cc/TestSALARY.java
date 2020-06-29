package com.cc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by trapaank1 on 03/03/19.
 */
public class TestSALARY {

    @Test
    public void testSalary() {
        Assert.assertEquals(0, SALARY.calculateSteps(new int[]{1}, 1));
        Assert.assertEquals(3, SALARY.calculateSteps(new int[]{1, 2, 3}, 1));
        Assert.assertEquals(0, SALARY.calculateSteps(new int[]{42, 42}, 42));
    }
}