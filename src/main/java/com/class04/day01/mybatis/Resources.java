package com.class04.day01.mybatis;

import java.io.InputStream;

public class Resources {
    public static InputStream getResourceAsStream(String config)
    {
        return Resources.class.getClassLoader().getResourceAsStream(config);
    }
}
