package com.cp3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ankur on 25/3/17.
 */
public class PostFixEvalTest {
    @Test(expected = Exception.class)
    public void evaluate() throws Exception {
        //assertEquals(new Integer(9), PostFixEval.evaluate("12+3*"));
        //assertEquals(new Integer(5), PostFixEval.evaluate("23+79/-"));
        assertEquals(new Integer(5), PostFixEval.evaluate("23+79/-+-"));
    }

}