package com.hc.mybatis.dao;


import com.hc.mybatis.dao.impl.UserDaoImpl;
import com.hc.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {
    public UserDao userDao;
    public SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        // mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        this.sqlSession = sqlSessionFactory.openSession();
        this.userDao = new UserDaoImpl(this.sqlSession);
    }

    @Test
    public void queryUserById() throws Exception{
        System.out.println(this.userDao.queryUserById(1));
    }

    @Test
    public void queryUserAll() {
        List<User> users = this.userDao.queryUserAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setAge(22);
        user.setBirthday(new Date("1999/09/04"));
        user.setName("Jack");
        user.setPassword("1234252");
        user.setSex(1);
        user.setUserName("May");
        this.userDao.insertUser(user);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("静鹏");
        user.setPassword("654321");
        user.setSex(1);
        user.setUserName("evanjin");
        user.setId(1);
        this.userDao.updateUser(user);
        this.sqlSession.commit();
    }

    @Test
    public void deleteUser() {
        this.userDao.deleteUser(4);
        this.sqlSession.commit();
    }
}
