package com.zt.serviceListener.util;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ArraysUtilTest {
    @Test
    public void isInvalid() throws Exception {
        assertTrue(ArraysUtil.isInvalid(null));
        assertTrue(ArraysUtil.isInvalid(new String[]{}));
    }

}