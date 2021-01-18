package com.epam.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    private long id;
    private long id_user;
    private long[] id_products;
    private String comment;
}
