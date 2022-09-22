package com.xiaozh.cases.json;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangxinyu
 * @since 2022/9/19 16:16
 */
public class Case1Test {
    @Test
    public void case1() throws ClassNotFoundException {
        Map<String, Object> soldier = new HashMap<>();
        soldier.put("username", "Schwartzenberge");
        soldier.put("age", 60);

        List<Map<String, Object>> weapons = new ArrayList<>();

        HashMap<String, Object> weapon1 = new HashMap<>();
        weapon1.put("name", "Searing Totem");
        weapon1.put("attack", 200000);

        HashMap<String, Object> weapon2 = new HashMap<>();
        weapon2.put("name", "One-Handed Maces");
        weapon2.put("attack", 40000);

        weapons.add(weapon1);
        weapons.add(weapon2);

        soldier.put("weapons", weapons);
        soldier.put("classPath", "com.xiaozh.cases.json.Case1Test.Soldier");

        HashMap<String, Object> m = JSON.parseObject(JSON.toJSONString(soldier), HashMap.class);

        // 测试包找不到路径？  在main下可以正常获取
        Soldier o = (Soldier)JSON.parseObject(JSON.toJSONString(soldier), Class.forName(m.get("classPath").toString()));


    }

    @Data
    public static class Soldier {
        private String username;
        private int age;

        private List<Weapon> weapons;

    }

    @Data
    static class Weapon {
        private String name;
        private long attack;
    }
}
