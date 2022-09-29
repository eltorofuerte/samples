package com.arnoer.jdbc.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * JdbcDaoSupport注入数据源，生成了jdbcTemplate
 */
public class AccountDaoImpl extends JdbcDaoSupport {

    public void transferTo(String name, double balance) {
        String sql = "update account set amount = amount + ? where user_name = ?";
        this.getJdbcTemplate().update(sql, balance, name);
    }

}