package com.class04.day01.mybatis.proxy;

import com.class04.day01.mybatis.Mapper.Mapper;
import com.class04.day01.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    private Map<String, Mapper> mappers;
    private Connection connection;
    public MapperProxy(Map<String, Mapper> mappers,Connection connection)
    {
        this.mappers = mappers;
        this.connection = connection;
    }

//    增强Dao，核心文件
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        String key = className+"."+methodName;
        Mapper mapper = mappers.get(key);

        if(mapper==null)
        {
            throw new IllegalArgumentException("参数错误！");
        }
        return new Executor().selectList(mapper,connection);
    }
}
