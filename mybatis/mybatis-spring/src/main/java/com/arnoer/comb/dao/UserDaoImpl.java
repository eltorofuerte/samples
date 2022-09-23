package com.arnoer.comb.dao;

import com.arnoer.comb.po.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * sqlSessionDaoSupport实现了setSqlSessionFactory()
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    @Override
    public List<User> findAllUser() {
        SqlSession sqlSession = this.getSqlSession();
        return sqlSession.selectList("findAllUser");
    }
}
