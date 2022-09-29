package com.arnoer.jdbc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Arnoer
 * @since 2022/9/28 9:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-2.xml")
public class AccountServiceTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void transfer() {
        accountService.transfer();
    }
}