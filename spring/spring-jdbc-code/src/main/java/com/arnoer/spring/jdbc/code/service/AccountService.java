package com.arnoer.spring.jdbc.code.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Arnoer
 * @since 2022/9/29 10:10
 */
@Service
public class AccountService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void transfer(double amount, String from, String to) {
        String sql = "update account set amount = amount + ? where user_name=?";
        jdbcTemplate.update(sql, amount, from);
        // 进行事务测试
//        System.out.println(1 / 0);
        jdbcTemplate.update(sql, -amount, to);
    }
}
