package com.class04.day01.mybatis;

import com.class04.day01.mybatis.cfg.Configuration;
import com.class04.day01.mybatis.sqlSession.Default.DefaultSqlSessionFactory;
import com.class04.day01.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream config)
    {
        Configuration configuration = XMLConfigBuilder.loadConfiguration(config);
        System.out.println(configuration.getDriver());
        return new DefaultSqlSessionFactory(configuration);
    }
}
