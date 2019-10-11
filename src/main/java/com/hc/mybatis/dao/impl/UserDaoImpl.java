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
        return this.sqlSession.selectOne("UserDaoMapper.queryUserById");
    }

    public List<User> queryUserAll() {
        return this.sqlSession.selectList("UserDaoMapper.queryUserAll");
    }

    public void insertUser(User user) {
        this.sqlSession.insert("UserDaoMapper.insertUser");
    }

    public void updateUser(User user) {
        this.sqlSession.update("UserDaoMapper.updateUser");
    }

    public void deleteUser(Integer id) {
        this.sqlSession.delete("UserDaoMapper.deleteUser");
    }
}
