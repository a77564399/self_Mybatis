package com.class04.day01.mybatis;

public interface SqlSession {
//   使用泛型之前需要先声明
    <T> T getMapper(Class<T> daoInterfaceClass);

    void close();
}
