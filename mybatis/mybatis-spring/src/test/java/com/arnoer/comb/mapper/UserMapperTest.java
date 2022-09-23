package com.arnoer.comb.mapper;

import com.arnoer.comb.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Arnoer
 * @since 2022/9/23 19:01
 */
public class UserMapperTest {
    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void findAllUser() {

        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        List<User> allUser = userMapper.findAllUser();
        System.out.println(allUser);
    }
}