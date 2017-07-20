package io.github.apitestdev;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestModeTest {

    @Test
    public void fromString() throws Exception {
        assertEquals(null, TestMode.fromString(null));
        assertEquals(null, TestMode.fromString("123123"));
        assertEquals(TestMode.SINGLE, TestMode.fromString("single"));
        assertEquals(TestMode.FLOW, TestMode.fromString("FLOW"));
        assertEquals(TestMode.SINGLE, TestMode.fromString("Single"));
    }

}