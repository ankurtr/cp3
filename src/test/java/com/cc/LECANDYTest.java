package com.cc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by trapaank1 on 26/02/19.
 */
public class LECANDYTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void canDistributeCandy() throws Exception {
        assertEquals("No", LECANDY.canDistributeCandy(null, new int[]{1, 2}));
        assertEquals("No", LECANDY.canDistributeCandy(new int[]{1, 2}, null));
        assertEquals("Yes", LECANDY.canDistributeCandy(new int[]{2, 3}, new int[]{1, 1}));
        assertEquals("No", LECANDY.canDistributeCandy(new int[]{3, 7}, new int[]{4, 2, 2}));
    }

}