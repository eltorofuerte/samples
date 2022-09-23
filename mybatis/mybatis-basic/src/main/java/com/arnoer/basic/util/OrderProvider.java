package com.arnoer.basic.util;

import com.arnoer.basic.po.Order;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author Arnoer
 * @since 2022/9/23 15:41
 */
public class OrderProvider {
    private final String TBL_ORDER = "orders";

    public String queryOrderByParam(Order param) {
        SQL sql = new SQL().SELECT("*").FROM(TBL_ORDER);
        Integer userId = param.getUserId();
        if (userId != null) {
            sql.WHERE("user_id = #{userId}");
        }
        String number = param.getNumber();
        if (number != null) {
            sql.WHERE("number = #{number}");
        }
        return sql.toString();
    }
}
