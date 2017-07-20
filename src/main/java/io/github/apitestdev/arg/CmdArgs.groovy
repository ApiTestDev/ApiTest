package io.github.apitestdev.arg

import com.beust.jcommander.Parameter
import com.beust.jcommander.ParameterException
import io.github.apitestdev.TestMode
import io.github.apitestdev.script.Configuration

/**
 * 命令行参数
 */
class CmdArgs {
    @Parameter(
            names = '-m',
            description = 'mode of test',
            required = true,
            converter = ModeConverter.class
    )
    TestMode mode

    @Parameter(
            names = '-cf',
            description = 'file path of configuration',
            required = true,
            converter = ConfigConverter.class,
            validateWith = PathValidator.class,
            validateValueWith = ConfigValidator.class
    )
    Configuration configFile

    @Parameter(
            names = '-sp',
            description = 'folder path of single scripts',
            required = true,
            validateWith = PathValidator.class
    )
    String singlePath

    @Parameter(
            names = '-fp',
            description = 'folder path of flow scripts',
            validateWith = PathValidator.class
    )
    String flowPath

    @Parameter(
            names = '-h',
            description = 'show this help',
            help = true
    )
    boolean help

    void checkFP() {
        if (mode == TestMode.FLOW && flowPath == null) {
            throw new ParameterException("The following option is required: -fp")
        }
    }

    void reset() {
        mode = null
        configFile = null
        singlePath = null
        flowPath = null
        help = false
    }

}
