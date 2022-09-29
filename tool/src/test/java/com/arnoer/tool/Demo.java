package com.arnoer.tool;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Arnoer
 * @since 2022/9/29 17:19
 */
public class Demo {
    @Test
    public void tt() {
        double  comprehensiveIndRatio = 0.217;
        BigDecimal two = new BigDecimal(comprehensiveIndRatio * 100.0);
        int i = two.setScale(0, RoundingMode.DOWN).intValue();
        System.out.println(i);
    }
}
