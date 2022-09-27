package com.arnoer.aop.po;

/**
 * 需要被增强的类，即被代理类
 * @author zhang xinyu
 * @version v1.0
 * @date created in 2021-05-17 18:42
 */
public class Cat {
    public void eat() {
        System.out.println("cat eat fish");
    }
}
