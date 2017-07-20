package io.github.apitestdev.arg;

import com.beust.jcommander.IValueValidator;
import com.beust.jcommander.ParameterException;
import io.github.apitestdev.script.Configuration;

import java.util.LinkedList;
import java.util.List;

/**
 * 验证配置信息是否完整
 */
public class ConfigValidator implements IValueValidator<Configuration> {
    private final List<String> protocols = new LinkedList<>();

    {
        protocols.add("http");
        protocols.add("https");
    }

    @Override
    public void validate(String name, Configuration value) throws ParameterException {
        if (value == null)
            throw new ParameterException("can't parse configuration");

        if (!protocols.contains(value.getProtocol().toLowerCase()))
            throw new ParameterException("unsupported protocol: " + value.getProtocol());

        if (value.getHost() == null) {
            throw new ParameterException("host must not be null");
        }

        if (value.getPort() < 0) {
            throw new ParameterException("port must greater than 0");
        }

    }

}
