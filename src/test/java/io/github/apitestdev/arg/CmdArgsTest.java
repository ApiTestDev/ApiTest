package io.github.apitestdev.arg;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import io.github.apitestdev.test.TestUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CmdArgsTest {

    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Test
    public void validateNoMode() throws Exception {
        ex.expect(ParameterException.class);
        ex.expectMessage("The following option is required: -m");

        String[] args = {"-cf", TestUtil.FILE, "-sp", TestUtil.FOLDER};
        CmdArgs cmdArgs = new CmdArgs();
        new JCommander(cmdArgs, args);
        cmdArgs.checkFP();
    }

    @Test
    public void validateNoCF() throws Exception {
        ex.expect(ParameterException.class);
        ex.expectMessage("The following option is required: -cf");

        String[] args = {"-m", "single", "-sp", TestUtil.FOLDER};
        CmdArgs cmdArgs = new CmdArgs();
        new JCommander(cmdArgs, args);
        cmdArgs.checkFP();
    }

    @Test
    public void validateNoSP() throws Exception {
        ex.expect(ParameterException.class);
        ex.expectMessage("The following option is required: -sp");

        String[] args = {"-m", "single", "-cf", TestUtil.FILE};
        CmdArgs cmdArgs = new CmdArgs();
        new JCommander(cmdArgs, args);
        cmdArgs.checkFP();
    }

    @Test
    public void validateFlowNoFP() throws Exception {
        ex.expect(ParameterException.class);
        ex.expectMessage("The following option is required: -fp");

        String[] args = {"-m", "flow", "-cf", TestUtil.FILE, "-sp", TestUtil.FOLDER};
        CmdArgs cmdArgs = new CmdArgs();
        new JCommander(cmdArgs, args);
        cmdArgs.checkFP();
    }

    @Test
    public void validateSingle() throws Exception {
        String[] args = {"-m", "single", "-cf", TestUtil.FILE, "-sp", TestUtil.FOLDER};
        CmdArgs cmdArgs = new CmdArgs();
        new JCommander(cmdArgs, args);
        cmdArgs.checkFP();
    }

    @Test
    public void validateSingleWithFP() throws Exception {
        String[] args = {"-m", "single", "-cf", TestUtil.FILE, "-sp", TestUtil.FOLDER, "-fp", TestUtil.FOLDER};
        CmdArgs cmdArgs = new CmdArgs();
        new JCommander(cmdArgs, args);
        cmdArgs.checkFP();
    }

    @Test
    public void validateFlow() throws Exception {
        String[] args = {"-m", "flow", "-cf", TestUtil.FILE, "-sp", TestUtil.FOLDER, "-fp", TestUtil.FOLDER};
        CmdArgs cmdArgs = new CmdArgs();
        new JCommander(cmdArgs, args);
        cmdArgs.checkFP();
    }

    @Test
    public void validateHelp() throws Exception {
        String[] args = {"-h"};
        CmdArgs cmdArgs = new CmdArgs();
        new JCommander(cmdArgs, args);
        cmdArgs.checkFP();
    }

    @Test
    public void validateHelpWithAll() throws Exception {
        String[] args = {"-h", "-m", "flow", "-cf", TestUtil.FILE, "-sp", TestUtil.FOLDER, "-fp", TestUtil.FOLDER};
        CmdArgs cmdArgs = new CmdArgs();
        new JCommander(cmdArgs, args);
        cmdArgs.checkFP();
    }

    @Test
    public void validateHelpWithPart() throws Exception {
        String[] args = {"-h", "-fp", TestUtil.FOLDER};
        CmdArgs cmdArgs = new CmdArgs();
        new JCommander(cmdArgs, args);
        cmdArgs.checkFP();
    }

    @Test
    public void reset() throws Exception {
        String[] args = {"-m", "flow", "-cf", TestUtil.FILE, "-sp", TestUtil.FOLDER, "-fp", TestUtil.FOLDER};
        CmdArgs cmdArgs = new CmdArgs();
        new JCommander(cmdArgs, args);
        cmdArgs.checkFP();
        assertNotNull(cmdArgs.getMode());
        assertNotNull(cmdArgs.getConfigFile());
        assertNotNull(cmdArgs.getSinglePath());
        assertNotNull(cmdArgs.getFlowPath());

        cmdArgs.reset();
        assertNull(cmdArgs.getMode());
        assertNull(cmdArgs.getConfigFile());
        assertNull(cmdArgs.getSinglePath());
        assertNull(cmdArgs.getFlowPath());
    }

}