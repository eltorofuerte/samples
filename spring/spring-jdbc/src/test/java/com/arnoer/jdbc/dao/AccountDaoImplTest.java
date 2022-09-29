package com.arnoer.jdbc.dao;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Arnoer
 * @since 2022/9/27 20:05
 */
public class AccountDaoImplTest {
    @Test
    public void transferTo() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml");
        AccountDaoImpl accountDao = (AccountDaoImpl) context.getBean("accountDao");
        // 孙悟空上缴工资5000元
        accountDao.transferTo("sunwukong", 2000);

    }
}