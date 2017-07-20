package io.github.apitestdev.test;

/**
 * 测试帮助类
 */
public abstract class TestUtil {
    public static String FILE = TestUtil.class.getClassLoader().getResource("config.groovy").getFile();
    public static String FOLDER = TestUtil.class.getClassLoader().getResource("").getFile();
}
