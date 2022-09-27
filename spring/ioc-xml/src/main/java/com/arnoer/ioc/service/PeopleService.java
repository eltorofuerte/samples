package com.arnoer.ioc.service;

import com.arnoer.ioc.dao.PeopleDao;
import lombok.Data;

/**
 * @author Arnoer
 * @since 2022/9/27 11:44
 */
@Data
public class PeopleService {

    private PeopleDao peopleDao;

    public void service() {
        peopleDao.service();
    }
}
