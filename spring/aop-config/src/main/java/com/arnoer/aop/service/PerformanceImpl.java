package com.arnoer.aop.service;

import com.arnoer.aop.utils.ApiLog;
import org.springframework.stereotype.Service;

@Service
public class PerformanceImpl implements Performance {
    @Override
    @ApiLog(title = "注解的标题",isSaveRequestData = false)
    public String performance(int count) {
        System.out.println("演出开始");
        return "world";
    }
}
