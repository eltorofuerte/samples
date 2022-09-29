package com.arnoer.jdbc.po;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Arnoer
 * @since 2022/9/27 19:51
 */
@Data
@Accessors(chain = true)
public class Account {
    private int id;
    private String name;
    private double amount;
}
