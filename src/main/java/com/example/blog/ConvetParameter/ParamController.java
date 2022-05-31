package com.example.blog.ConvetParameter;

import org.springframework.web.bind.annotation.*;

@RestController
//@ResponseBody
@RequestMapping("/parameter")
public class ParamController {
    @GetMapping("/converter")
    public Car car(@RequestParam("carStr") Car carStr) {
        System.out.println(carStr);
        return carStr;
    }

}
