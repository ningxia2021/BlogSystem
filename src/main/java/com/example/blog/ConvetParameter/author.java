package com.example.blog.ConvetParameter;

import lombok.Data;

@Data
public class author {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
