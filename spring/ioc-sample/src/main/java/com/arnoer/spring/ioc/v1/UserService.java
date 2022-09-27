package com.arnoer.spring.ioc.v1;

/**
 * @author Arnoer
 * @since 2022/9/27 11:03
 */
// demo 不做接口扩展  思考：耦合性太强，如果dao有其他实现呢？需要修改dao的实现
public class UserService {
    // service直接依赖dao
    private UserDao userDao = new UserDaoImpl();

    public void learn() {
        userDao.learn();
    }
}
