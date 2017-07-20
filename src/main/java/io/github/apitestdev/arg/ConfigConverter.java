package io.github.apitestdev.arg;

import com.beust.jcommander.IStringConverter;
import io.github.apitestdev.script.Configuration;

/**
 * 将命令行中参数 -cf 的值转换为 Configuration 类型
 */
public class ConfigConverter implements IStringConverter<Configuration> {

    @Override
    public Configuration convert(String value) {
        // TODO impl
        return new Configuration() {
            {
                setHost("");
            }
            @Override
            public Object run() {
                return null;
            }
        };
    }

}
