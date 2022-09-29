package com.arnoer.jdbc.dao;

import com.arnoer.jdbc.po.Book;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 测试JDBCTemplate的crdud方法
 *
 */
public class JdbcTemplateTest {
    private static JdbcTemplate jdbcTemplate;

    static {
        // 设置mysql数据库连接信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///mp_demo?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Test
    public void testAdd() {
        String sql = "insert into tb_book values (?,?,?,?)";
        Object[] params = {"b12", "spring-core", 60, 4};
        jdbcTemplate.update(sql, params);
    }

    @Test
    public void testUpdate() {
        String sql = "update tb_book set bname = ? where bid = ?";
        Object[] params = {"spring-ioc", "b11"};
        jdbcTemplate.update(sql, params);
    }

    @Test
    public void testDelete() {
        String sql = "delete  from tb_book where bid = ?";
        jdbcTemplate.update(sql, "b11");
    }

    /**
     * 查询单行单列数据
     */
    @Test
    public void testQuery() {
        String sql = "select count(*) from tb_book";
        // param: Class<T> requiredType 指定返回值的数据类型
        Integer count = jdbcTemplate.queryForObject(sql, int.class);
        System.out.println(count);
    }

    /**
     * 将一行数据映射为一个对象
     */
    @Test
    public void testQueryObject() {
        String sql = "select * from tb_book where bid = ?";
        // rowMapper : 将结果集映射成指定的对象，参考dbutils中的ResultHandler，都是将ResultSet中的数据封装
        Book book = jdbcTemplate.queryForObject(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                String bid = resultSet.getString("bid");
                String bname = resultSet.getString("bname");
                double price = resultSet.getDouble("price");
                int category = resultSet.getInt("category");
                Book book = new Book();
                book.setBid(bid);
                book.setBname(bname);
                book.setPrice(price);
                book.setCategory(category);
                return book;
            }
        }, "b1");
        System.out.println(book);
    }

    /**
     * 将查询结果封装为对象集合
     */
    @Test
    public void testQueryList() {
        String sql = "select * from tb_book";
        List<Book> bookList = jdbcTemplate.query(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                String bid = resultSet.getString("bid");
                String bname = resultSet.getString("bname");
                double price = resultSet.getDouble("price");
                int category = resultSet.getInt("category");
                Book book = new Book();
                book.setBid(bid);
                book.setBname(bname);
                book.setPrice(price);
                book.setCategory(category);
                return book;
            }
        });
        System.out.println(bookList);
    }
}
