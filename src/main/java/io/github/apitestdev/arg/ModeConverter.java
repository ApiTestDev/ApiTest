package io.github.apitestdev.arg;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.ParameterException;
import io.github.apitestdev.TestMode;

/**
 * 将命令行中参数 -m 的值转换为 TestMode 类型
 */
public class ModeConverter implements IStringConverter<TestMode> {

    @Override
    public TestMode convert(String value) {
        TestMode mode = TestMode.fromString(value);
        if (mode == null) {
            throw new ParameterException("Unsupported mode: " + value);
        }
        return mode;
    }

}
