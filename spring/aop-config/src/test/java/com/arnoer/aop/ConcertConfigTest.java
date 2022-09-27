package com.arnoer.aop;

import com.arnoer.aop.aspect.Audience;
import com.arnoer.aop.config.ConcertConfig;
import com.arnoer.aop.service.Encoreable;
import com.arnoer.aop.service.Performance;
import com.arnoer.aop.service.PerformanceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 经过测试，performance和encoreable被同一个代理对象代理
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConcertConfig.class})
public class ConcertConfigTest {

    @Autowired
    private Performance performance;

    @Autowired
    private Encoreable encoreable;

    @Test
    public void proxyTest() {
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(new PerformanceImpl());
        factory.addAspect(new Audience());
        Performance proxy = factory.getProxy();
        proxy.performance(12);
    }

    @Test
    public void run() {
        // 测试通知
        performance.performance(12);

        // 测试引入的接口方法
        Encoreable performance1 = (Encoreable) this.performance;
        performance1.performEncore();

        Performance encoreable = (Performance) this.encoreable;
        encoreable.performance(12);

    }

}