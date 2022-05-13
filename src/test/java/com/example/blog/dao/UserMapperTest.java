package com.example.blog.dao;

import com.example.blog.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Resource
    private UserMapper userMapper;
    @Test
    void addUser() {
        User user = new User();
        user.setUsername("高华");
        user.setPassword("123");
        userMapper.addUser(user);
    }

    @Test
    void selectUserAll() {
    }

    @Test
    void selectUserByUsername() {
    }

    @Test
    void selectUserById() {
    }
}