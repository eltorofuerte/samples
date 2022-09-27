package com.arnoer.spring.ioc.v1;

/**
 * @author Arnoer
 * @since 2022/9/27 11:02
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void learn() {
        System.out.println("userDao method learn================");
    }
}
