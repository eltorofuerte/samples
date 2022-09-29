package com.arnoer.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Arnoer
 * @since 2022/9/27 19:58
 */
public class JdbcConnectionTest {

    private static String url = "jdbc:mysql:///mp_demo?serverTimezone=UTC";
    private static String driverClass = "com.mysql.cj.jdbc.Driver";
    private static String username = "root";
    private static String password = "root";

//    static {
//        ResourceBundle bundle = ResourceBundle.getBundle("jdbc.properties");
//        String driver = bundle.getString("jdbc.driver");
//    }

    @Test
    public void testConnectionMySQL() throws Exception {
        Class.forName(driverClass);
        Connection c = DriverManager.getConnection(url, username, password);
        Assert.assertNotNull(c);
    }

    @Test
    public void testC3p0() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        Connection c = dataSource.getConnection();
        Assert.assertNotNull(c);
    }
}
