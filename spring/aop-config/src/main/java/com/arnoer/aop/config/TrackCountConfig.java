package com.arnoer.aop.config;

import com.arnoer.aop.aspect.TrackCounter;
import com.arnoer.aop.po.BlankDisc;
import com.arnoer.aop.service.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.arnoer.aop")
public class TrackCountConfig {
    @Bean
    public CompactDisc sgtPeppers() {
        return new BlankDisc("cd", "cd");
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }
}
