package com.arnoer.ioc.po;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author Arnoer
 * @since 2022/9/27 11:29
 */
@Data
public class People {
    private String name;
    private int age;
    
    private Heart heart;

    // 注入不同数据类型的方式
    private String[] hobbies;
    private List<String> list;
    private Map<String,String> map;
    private Properties properties;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public People(String name, int age, Heart heart) {
        this.name = name;
        this.age = age;
        this.heart = heart;
    }

    public People() {
    }

    public People(String name, int age, Heart heart, String[] hobbies) {
        this.name = name;
        this.age = age;
        this.heart = heart;
        this.hobbies = hobbies;
    }
}
