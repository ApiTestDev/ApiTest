package io.github.apitestdev.arg;

import com.beust.jcommander.ParameterException;
import io.github.apitestdev.script.Configuration;
import org.junit.Before;
import org.junit.Test;

public class ConfigValidatorTest {
    private Configuration config = new TestConfig();
    private ConfigValidator v = new ConfigValidator();

    @Before
    public void init() {
        config.setProtocol("http");
        config.setHost("1.2.3.4");
        config.setPort(80);
    }

    @Test(expected = ParameterException.class)
    public void validateNullValue() throws Exception {
        v.validate(null, null);
    }

    @Test(expected = ParameterException.class)
    public void validateUnsupportedProtocol() throws Exception {
        config.setProtocol("rpc");
        v.validate(null, config);
    }

    @Test(expected = ParameterException.class)
    public void validateNullHost() throws Exception {
        config.setHost(null);
        v.validate(null, config);
    }

    @Test(expected = ParameterException.class)
    public void validateNegativePort() throws Exception {
        config.setPort(-1);
        v.validate(null, config);
    }

    @Test
    public void validate() throws Exception {
        v.validate(null, config);
    }

    class TestConfig extends Configuration {
        @Override
        public Object run() {
            return null;
        }
    }

}