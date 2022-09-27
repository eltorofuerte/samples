package com.arnoer.aop.aspect;

import com.arnoer.aop.utils.ApiLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 定义切面：切入点和通知
 */
@Aspect
public class Audience {
    @Pointcut(value = "execution(* com.arnoer.aop.service.Performance.*(..))")
    public void performance() {
    }

    @Before("performance()")
    public void silenceCellPhones(JoinPoint joinPoint) throws NoSuchMethodException {
        Object target = joinPoint.getTarget(); // PerformanceImpl@2553
        Object aThis = joinPoint.getThis(); // PerformanceImpl@5bda80bf($Proxy30@2526)
        Object[] args = joinPoint.getArgs();
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();

        // 获取方法上的注解
        Method method1 = joinPoint.getTarget().getClass().getMethod(method.getName(), method.getParameterTypes());
        if (method1 != null) {
            ApiLog annotation = method1.getAnnotation(ApiLog.class);
            String title = annotation.title();
            System.out.println("注解@ApiLogs上的信息是" + title);
            System.out.println("目标方法"+ method1.getName()+"上的注解有：" + Arrays.asList(method1.getAnnotations()));
        }
        // 获取方法参数上的注解
        Annotation[][] pas = method.getParameterAnnotations();
        for (Annotation[] pa : pas) {
        }
        // 演出开始之前，手机静音
        System.out.println("Silencing cell phones");
    }

    @Before("performance()")
    public void takeSeats() {
        // 演出开始之前，就坐
        System.out.println("Taking seats");
    }

    /**
     * args绑定目标方法的参数值，returning指定目标方法的返回值，参数类型会限定目标方法的返回类型
     * （如果返回类型非参数类型的实现，返回通知不会执行）
     * @param count
     * @param result
     */
    @AfterReturning(pointcut = "performance() && args(count)", returning = "result")
    public void applause(int count, String result) {
        // 演出之后，观众喝彩
        System.out.println("clap clap clap");
    }

    @AfterThrowing(pointcut = "performance()", throwing = "e")
    public void demandRefund(Exception e) {
        // 演出失败，要求退票
        System.out.println("Demanding a refund");
    }
}
