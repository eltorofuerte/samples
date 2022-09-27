package com.arnoer.aop.config;

import com.arnoer.aop.aspect.Audience;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.arnoer.aop")
public class ConcertConfig {
    @Bean
    public Audience audience() {
        return new Audience();
//        return new Audience2();
    }
}
