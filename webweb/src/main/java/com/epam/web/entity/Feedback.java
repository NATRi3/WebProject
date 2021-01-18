package com.epam.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Feedback {
    private long id;
    private long id_user;
    private long id_product;
    private TypeEvaluation evalution;
    private String info;
}
