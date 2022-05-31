package com.example.blog.ConvetParameter;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
//@Component
public class Car {
    private String brand;
    private String price;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
