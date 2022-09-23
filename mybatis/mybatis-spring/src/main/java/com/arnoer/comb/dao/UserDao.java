package com.arnoer.comb.dao;

import com.arnoer.comb.po.User;

import java.util.List;

/**
 * @author dhjy
 * @version v1.0
 * @date created in 2021-05-20 20:44
 */
public interface UserDao {
    /**
     * 通过用户id查询用户信息

     * @return
     */
    List<User> findAllUser();
}
