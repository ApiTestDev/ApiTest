package io.github.apitestdev.arg;

import com.beust.jcommander.ParameterException;
import io.github.apitestdev.test.TestUtil;
import org.junit.Test;

public class PathValidatorTest {
    private PathValidator v = new PathValidator();

    @Test(expected = ParameterException.class)
    public void validateNull() throws Exception {
        v.validate(null, null);
    }

    @Test(expected = ParameterException.class)
    public void validateDontExist() throws Exception {
        v.validate(null, "123123");
    }

    @Test(expected = ParameterException.class)
    public void validateCfDirectory() throws Exception {
        v.validate("-cf", TestUtil.FOLDER);
    }

    @Test
    public void validateCfFile() throws Exception {
        v.validate("-cf", TestUtil.FILE);
    }

    @Test
    public void validateDirectory() throws Exception {
        v.validate("-sp", TestUtil.FOLDER);
    }

    @Test(expected = ParameterException.class)
    public void validateFile() throws Exception {
        v.validate("-fp", TestUtil.FILE);
    }

}