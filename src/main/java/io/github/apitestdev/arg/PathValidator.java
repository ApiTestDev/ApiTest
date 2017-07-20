package io.github.apitestdev.arg;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import java.io.File;

/**
 * 验证命令行参数中设置的路径是否正确
 */
public class PathValidator implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {
        if (value == null)
            throw new ParameterException("path of " + name + " is null");

        File f = new File(value);
        if (!f.exists())
            throw new ParameterException("path of " + name + " is not exist");

        if (name.equals("-cf")) {
            if (f.isDirectory())
                throw new ParameterException("path of " + name + " is not a file");
        } else {
            if (f.isFile())
                throw new ParameterException("path of " + name + " is not a directory");
        }
    }

}
