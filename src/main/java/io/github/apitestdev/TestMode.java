package io.github.apitestdev;

/**
 * 测试类型
 */
public enum TestMode {
    SINGLE,
    FLOW;

    public static TestMode fromString(String name) {
        if (name == null)
            return null;

        name = name.toUpperCase();
        for (TestMode m : values()) {
            if (name.equals(m.name()))
                return m;
        }
        return null;
    }

}
