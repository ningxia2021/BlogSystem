package com.example.blog.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private int userId;
    private String username;
    private String password;

}
