package com.example.blog.common;

import com.example.blog.entity.User;
import org.springframework.context.annotation.Configuration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class util {
//    1.登录状态检测
    public static User checkLoginStatus(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null){
            return null;
        }
        User user = (User) session.getAttribute("user");
        if (user == null){
            return null;
        }
        return user;
    }
}
