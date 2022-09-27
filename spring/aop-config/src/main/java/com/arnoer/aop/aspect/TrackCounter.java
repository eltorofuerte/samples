package com.arnoer.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * aspect处理通知中参数的方式
 */
@Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>(16);

    @Pointcut("execution(* com.arnoer.aop.service.CompactDisc.playTrack(int ))&& args(trackNumber)")
    public void trackPlayed(int trackNumber) {

    }
    /*
     * @param food  使用return可以获取目标方法的返回值，该参数类型会限定目标方法的返回类型（如果返回类型非参数类型的实现，返回通知不会执行）
     * @param food2 使用args设定可以获取目标方法出入的参数的值
     */
    @Before(value = "trackPlayed(trackNumber)", argNames = "trackNumber")
    public void countTrack(int trackNumber) {
        // 播放前为磁道计数
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    private int getPlayCount(int trackNumber) {
        return trackCounts.getOrDefault(trackNumber, 0);
    }
}
