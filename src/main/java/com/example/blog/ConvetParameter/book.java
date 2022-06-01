package com.example.blog.ConvetParameter;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class book {
    private String name;
    private author author;
    private Date date;
    private double price;
}
