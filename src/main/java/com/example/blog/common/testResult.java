package com.example.blog.common;

import com.example.blog.dao.UserMapper;
import com.example.blog.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

@Controller
public class testResult {

    @Resource
    UserMapper userMapper;

    @GetMapping("/test1")
    @ResponseBody
    public Result list1(){
        return ResultGenerator.genSuccessResult("测试");
    }

    @GetMapping("/test2")
    @ResponseBody
    public Result list2(){
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/test3")
    @ResponseBody
    public Result list3(){
        List<User> users = userMapper.selectUserAll();
        return ResultGenerator.genSuccessResult(users);
    }

    @GetMapping("/test4")
    @ResponseBody
    public Result list4(){
        return ResultGenerator.genErrorResult(800,"测试错误码");
    }

    @GetMapping("/test5")
    @ResponseBody
    public Result list5(){
        return ResultGenerator.genFailResult("失败");
    }

}
