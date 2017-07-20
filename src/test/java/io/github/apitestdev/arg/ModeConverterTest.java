package io.github.apitestdev.arg;

import com.beust.jcommander.ParameterException;
import io.github.apitestdev.TestMode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModeConverterTest {
    private ModeConverter c = new ModeConverter();

    @Test
    public void convert() throws Exception {
        assertEquals(TestMode.SINGLE, c.convert("single"));
        assertEquals(TestMode.FLOW, c.convert("FLOW"));
        assertEquals(TestMode.SINGLE, c.convert("Single"));
    }

    @Test(expected = ParameterException.class)
    public void convertNull() throws Exception {
        c.convert(null);
    }

    @Test(expected = ParameterException.class)
    public void convertInvalid() throws Exception {
        c.convert("123123");
    }

}