package com.arnoer.jdbc.po;

import lombok.Data;

/**
 * @author Arnoer
 * @since 2022/9/28 7:34
 */
@Data
public class Book {
    private String bid;
    private String bname;
    private double price;
    private int category;
}
