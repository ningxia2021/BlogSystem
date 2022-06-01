package com.example.blog.ConvetParameter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class test6 {
    @PostMapping("/test6")
    @ResponseBody
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public String test(book book){
        return book.toString();
    }

}
