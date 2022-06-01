package com.example.blog.ConvetParameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * 参数转换
 * 将BYD,12.22字符串转换成Car对象
 */
@Component
public class StringToCarConverter implements Converter<String, Date> {
    //    @Override
//    public Car convert(String source) {
//        if (!StringUtils.isEmpty(source)){
//            Car car = new Car();
//            String[] arr = source.split(",");
//            car.setBrand(arr[0]);
//            car.setPrice(arr[1]);
//            return car;
//        }
//        return null;
//    }

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String source) {
        try {
            simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
