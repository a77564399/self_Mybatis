package com.test;

import com.class04.day01.dao.IUserDao;
import com.class04.day01.domain.User;
import com.class04.day01.mybatis.Resources;
import com.class04.day01.mybatis.SqlSession;
import com.class04.day01.mybatis.SqlSessionFactory;
import com.class04.day01.mybatis.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.sql.DriverManager;
import java.util.List;

public class MybatisTets {
    public static void main(String[] args) throws Exception{
//        1����ȡ�������ļ�
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
//        2������SqlSessionFactory����
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sfb.build(is);

//        3��ʹ�ù�������sqlsession����
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        4��ʹ��sqlsession����Dao�ӿڵĴ������
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
//        5��ʹ�ô������ִ�з���
        List<User> userList = iUserDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
//        6���ͷ���Դ
        sqlSession.close();

    }
}
