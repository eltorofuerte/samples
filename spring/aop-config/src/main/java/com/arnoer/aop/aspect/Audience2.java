package com.arnoer.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 使用@Around替代
 */
@Aspect
//@Component
public class Audience2 {

    @Pointcut(value = "execution(* com.arnoer.aop.service.Performance.*(..))")
    public void performance() {
    }

    @Around("performance()")
    public Object watchePerformance(ProceedingJoinPoint pj) {
        Object obj = null;
        try {
            System.out.println("silencing cell phones"); // before
            System.out.println("taking seats");
            obj = pj.proceed();// 执行目标方法
            System.out.println("CLAP CLAP CLAP"); // afterreturn
        } catch (Throwable e) {
            System.out.println("Demanding a refund"); // rnm, 退钱！
        } finally {
            System.out.println("must be");
        }
        return obj;
    }
}
