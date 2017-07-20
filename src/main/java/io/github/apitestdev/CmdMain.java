package io.github.apitestdev;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import io.github.apitestdev.arg.CmdArgs;

/**
 * 命令行入口
 */
public class CmdMain {
    private CmdArgs cmdArgs = new CmdArgs();

    public static void main(String[] args) {
        CmdMain main = new CmdMain();
        main.handleArgs(args);
    }

    public void handleArgs(String[] args) {
        try {
            JCommander jc = new JCommander(cmdArgs, args);
            if(cmdArgs.isHelp()) {
                cmdArgs.reset();
                jc.usage();
                System.exit(0);
            }
            // TODO run
        } catch (ParameterException e) {
            System.err.println(e.getMessage());
            cmdArgs.reset();
            new JCommander(cmdArgs).usage();
            e.printStackTrace();
        }
    }

}
