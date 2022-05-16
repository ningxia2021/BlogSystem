package com.example.blog.common;

import java.io.Serializable;

/**
 * 定义属性类
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
//    定义返回结果属性
    private int resultCode;
    private String message;
    private T data;

//    无参构造
    public Result() {

    }

//    有参构造
    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
