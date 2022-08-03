package com.class04.day01.mybatis.sqlSession.Default;

import com.class04.day01.mybatis.Mapper.Mapper;
import com.class04.day01.mybatis.SqlSession;
import com.class04.day01.mybatis.cfg.Configuration;
import com.class04.day01.mybatis.proxy.MapperProxy;
import com.class04.day01.mybatis.utils.DataSourceUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        this.connection = DataSourceUtil.getConnection(cfg);
    }
//   直接这也声明并不会执行这个方法，需要在初始化中设置
//    Connection connection = DataSourceUtil.getConnection(cfg);
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        T t = (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(),connection));
        return t;
    }

    @Override
    public void close() {
        if(connection!=null)
        {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
