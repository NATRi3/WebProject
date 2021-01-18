package com.epam.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private long id;
    private String name;
    private String email;
    private TypeAccess access;
    private String imageName;
    private TypeRole role;


    public User(long id, String name, String email,  TypeAccess access) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.access = access;
    }
}
