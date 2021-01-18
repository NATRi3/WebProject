package com.epam.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private long id;
    private String name;
    private String info;
    private BigDecimal price;
    private String imageName;
    private long id_user;
    private TypeStatus status;

    public Product(String name, String info, BigDecimal price, long id_user, String imageName) {
        this.name = name;
        this.info = info;
        this.price = price;
        this.id_user = id_user;
        this.imageName = imageName;
    }
}
