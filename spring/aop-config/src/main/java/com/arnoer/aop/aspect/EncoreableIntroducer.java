package com.arnoer.aop.aspect;


import com.arnoer.aop.service.DefaultEncoreable;
import com.arnoer.aop.service.Encoreable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * 为Performance的子类对象引入新的接口方法
 */
@Aspect
@Component
public class EncoreableIntroducer {
    // Performance的子类型会引入该接口，引入功能的实现类是DefaultEncoreable
    @DeclareParents(value = "com.arnoer.aop.service.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
