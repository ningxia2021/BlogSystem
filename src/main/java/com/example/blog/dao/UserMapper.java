package com.example.blog.dao;

import com.example.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
//    新建用户 这个操作对应注册
    void addUser(User user);
//    查询所有用户
    List<User> selectUserAll();
//    根据用户名查找用户信息 ,这个操作对应登录
    User selectUserByUsername(String username);
//    根据用户id来查找用户对象 （这个是后续在博客页面上显示作者的必要操作）
    User selectUserById(int id);
}
