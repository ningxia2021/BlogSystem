package com.example.blog.ConvetParameter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
/**参数转换
 * 将BYD,12.22字符串转换成Car对象
 */
@Component
public class StringToCarConverter implements Converter<String,Car> {
    @Override
    public Car convert(String source) {
        if (!StringUtils.isEmpty(source)){
            Car car = new Car();
            String[] arr = source.split(",");
            car.setBrand(arr[0]);
            car.setPrice(arr[1]);
            return car;
        }
        return null;
    }
}
