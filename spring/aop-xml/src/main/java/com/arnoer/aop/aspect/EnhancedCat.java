package com.arnoer.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定义切面的增强逻辑
 */
public class EnhancedCat {

    public static final Logger LOGGER = LoggerFactory.getLogger(EnhancedCat.class);

    /**
     * 对应@Before的前置增强
     */
    public void doBefore() {
        LOGGER.info("doBefore");
        System.out.println("clean claws");
    }

    /**
     * 对应@After的后置增强，一定执行
     */
    public void doAfter() {
        LOGGER.info("doAfter");
    }

    /**
     * 对应@AfterRetruning的返回通知
     */
    public void doAfterReturning() {
        LOGGER.info("doAfterReturning");
    }

    /**
     * 对应@AfterThrowing的异常切面逻辑
     */
    public void doAfterThrowing() {
        LOGGER.info("doAfterThrowing");
    }

    /**
     * 环绕增强
     */
    public void doAround(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            try {
                doBefore();
                // 执行通知bean的方法
                proceedingJoinPoint.proceed();
            } finally {
                doAfter();
            }
            doAfterReturning();
        } catch (Throwable throwable) {
            doAfterThrowing();
        }
    }
}
