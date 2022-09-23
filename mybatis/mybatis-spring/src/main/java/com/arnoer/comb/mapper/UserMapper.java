package com.arnoer.comb.mapper;

import com.arnoer.comb.po.User;

import java.util.List;

/**
 * @author dhjy
 * @version v1.0
 * @date created in 2021-05-20 22:42
 */
public interface UserMapper {
    /**
     * 查询所有的用户信息
     *
     * @return
     */
    List<User> findAllUser();
}
