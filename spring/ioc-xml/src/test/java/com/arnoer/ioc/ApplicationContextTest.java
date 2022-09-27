package com.arnoer.ioc;

import com.arnoer.ioc.po.People;
import com.arnoer.ioc.service.PeopleService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Arnoer
 * @since 2022/9/27 11:54
 */
public class ApplicationContextTest {
    private ClassPathXmlApplicationContext context;

    @Before
    public void init() {
        // 加载spring配置文件，构建spring容器
        context = new ClassPathXmlApplicationContext("applicationContext_1.xml");
    }

    @Test
    public void t1() {
        People p1 = (People)context.getBean("p1");
        System.out.println(p1);
    }

    @Test
    public void ps() {
        PeopleService ps = (PeopleService)context.getBean("ps");
        System.out.println(ps);
    }

}
