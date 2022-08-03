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
//        1、读取主配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
//        2、创建SqlSessionFactory工程
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sfb.build(is);

//        3、使用工厂创建sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        4、使用sqlsession创建Dao接口的代理对象
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
//        5、使用代理对象执行方法
        List<User> userList = iUserDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
//        6、释放资源
        sqlSession.close();

    }
}
