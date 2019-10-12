package com.hc.mybatis.dao.impl;

import com.hc.mybatis.pojo.User;
import com.hc.mybatis.dao.UserDao;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User queryUserById(Integer id) {
        return this.sqlSession.selectOne("UserDao.queryUserById", id);
    }

    public List<User> queryUserAll() {
        return this.sqlSession.selectList("UserDao.queryUserAll");
    }

    public void insertUser(User user) {
        this.sqlSession.insert("UserDao.insertUser", user);
    }

    public void updateUser(User user) {
        this.sqlSession.update("UserDao.updateUser", user);
    }

    public void deleteUser(Integer id) {
        this.sqlSession.delete("UserDao.deleteUser", id);
    }
}
