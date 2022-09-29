package com.arnoer.spring.jdbc.code;

import com.arnoer.spring.jdbc.code.config.JdbcConfiguration;
import com.arnoer.spring.jdbc.code.config.TxManagerConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Arnoer
 * @since 2022/9/29 10:04
 */
@Configuration
@ComponentScan // 扫描@Component @Configuration
@Import({JdbcConfiguration.class, TxManagerConfiguration.class}) // spring4.2后@import可以导入普通类
@EnableAspectJAutoProxy // 开启AOP自动代理支持
@EnableTransactionManagement // 开启事务注解支持
public class MainApplication {
}
