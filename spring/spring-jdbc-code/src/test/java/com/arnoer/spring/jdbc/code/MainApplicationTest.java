package com.arnoer.spring.jdbc.code;

import com.arnoer.spring.jdbc.code.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author Arnoer
 * @since 2022/9/29 10:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MainApplication.class})
public class MainApplicationTest {

    @Resource
    private AccountService accountService;
    @Test
    public void demo() {
        accountService.transfer(1000, "sunwukong", "sunwufan");
    }
}