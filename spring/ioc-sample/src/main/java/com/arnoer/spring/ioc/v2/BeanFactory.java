package com.arnoer.spring.ioc.v2;

import java.util.ResourceBundle;

/**
 * 使用静态工厂模式，结合反射来实例化接口的一个实现类对象
 *
 * @author Arnoer
 * @since 2022/9/27 11:08
 */
public class BeanFactory {

    /**
     * 读取资源文件
     */
    private static ResourceBundle beanStrings = ResourceBundle.getBundle("bean");

    public static Object getBean(String beanName) {
        try {
            String beanRef = beanStrings.getString(beanName);
            return Class.forName(beanRef).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
