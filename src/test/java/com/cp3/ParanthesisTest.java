package com.cp3;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by ankur on 25/3/17.
 */
public class ParanthesisTest {
    @Test
    public void validateParans() throws Exception {
        assertTrue(Paranthesis.validateParans("[({})]"));
        assertFalse(Paranthesis.validateParans("[{)"));
        assertTrue(Paranthesis.validateParans("[()]"));
        assertFalse(Paranthesis.validateParans("[()]}"));
    }

}