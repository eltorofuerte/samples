package com.arnoer.jdbc.service;

import com.arnoer.jdbc.dao.AccountDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Arnoer
 * @since 2022/9/27 19:56
 */
@Service
public class AccountService {
    @Autowired
    @Qualifier("b1")
    private AccountDaoImpl accountDao;

    /**
     * 修改测试用的配置文件为applicationContext3.xml：使用注解的形式配置事务  @Transactional
     * applicationContext2.xml去掉该注解@Transactional
     * */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void transfer() {
        accountDao.transferTo("sunwukong", -1000);
        // 进行事务测试
        System.out.println(1 / 0);
        accountDao.transferTo("sunwufan", 1000);
    }
}
