package com.example.blog.common;

import lombok.Data;

import java.util.Map;

@Data
public class Result {
    private int status;
    private String mes;
    private Map<String,Object> data;

//    public Result data(String key, Object value) {
//        this.data.put(key, value);
//        return this;
//    }

    public void setData(String key, Object value) {
        this.data.put(key, value);
    }
}
