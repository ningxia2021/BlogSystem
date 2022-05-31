package com.example.blog.ConvetParameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class WebConfigurer implements WebMvcConfigurer {
    @Autowired
    StringToCarConverter stringToCarConverter;
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToCarConverter);
    }
}
