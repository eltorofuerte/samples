package com.arnoer.aop.aspect;

import com.arnoer.aop.po.Cat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Arnoer
 * @since 2022/9/27 13:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EnhancedCatTest {

    @Test
    public void eat() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Cat cat = (Cat) context.getBean("cat");
        cat.eat();
    }
}