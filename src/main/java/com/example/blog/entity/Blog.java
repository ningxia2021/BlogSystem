package com.example.blog.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Blog {
    private int blogId;
    private String title;
//    博客内容
    private String content;
//    发布时间
    private Timestamp postTime;
    private int userId;
}
