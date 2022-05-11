package com.example.blog.controller;

import com.example.blog.dao.BlogMapper;
import com.example.blog.entity.Blog;
import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BlogServlet {

    @Resource
    private BlogMapper blogMapper;


    /**
     * 一个blog要干两件事儿
     * 如果url为 /blog
     * @return
     */
    @GetMapping("/blog")
    @ResponseBody
    public List<Blog> blogList() {
//        1.查询所有博客信息
        List<Blog> blogs = blogMapper.selectAllBlog();

//        2.返回json对象
        return blogs;
    }

    @GetMapping("/detail")
    @ResponseBody
    public Blog blogDetail(Integer blogId){
        Blog blog = blogMapper.selectByBlogId(blogId);
        return blog;
    }

}
