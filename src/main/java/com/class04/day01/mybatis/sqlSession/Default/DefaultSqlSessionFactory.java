package com.class04.day01.mybatis.sqlSession.Default;

import com.class04.day01.mybatis.SqlSession;
import com.class04.day01.mybatis.SqlSessionFactory;
import com.class04.day01.mybatis.cfg.Configuration;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg)
    {
        this.cfg = cfg;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
