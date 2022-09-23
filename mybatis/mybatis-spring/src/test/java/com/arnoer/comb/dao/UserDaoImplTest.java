package com.arnoer.comb.dao;

import com.arnoer.comb.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author Arnoer
 * @since 2022/9/23 18:52
 */
public class UserDaoImplTest {

    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void findAllUser() {
        UserDao userDao = applicationContext.getBean(UserDao.class);
        List<User> allUser = userDao.findAllUser();
        System.out.println(allUser);

        System.out.println(Charset.defaultCharset().name());
    }


}