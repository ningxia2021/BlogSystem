package com.example.blog.controller;

import com.example.blog.common.util;
import com.example.blog.dao.BlogMapper;
import com.example.blog.dao.UserMapper;
import com.example.blog.entity.Blog;
import com.example.blog.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class BlogServlet {

    @Resource
    private BlogMapper blogMapper;
    @Resource
    private UserMapper userMapper;

    /**
     * 登录页逻辑
     * 和用户有关的信息会再登录后保存在session中，到时通过request.getSession()来获取
     */
    @PostMapping("/login")
    @ResponseBody
    public void UserLogin(@RequestParam("username") String username, @RequestParam("password") String password,
                          HttpServletRequest request, HttpServletResponse response) throws IOException {

//        用户名 密码 非空校验
        response.setContentType("text/html;charset=utf-8");
        if (username == null || username.equals("") || password == null || password.equals("")) {
            String html = "<h3>用户名或密码不能为空</h3>";
            response.getWriter().write(html);
            return;
        }
//        查找user信息
        User user = userMapper.selectUserByUsername(username);
//        判断user是否存在
        if (user == null) {
            String html = "<h3>当前用户名不存在</h3>";
            response.getWriter().write(html);
            return;
        }
//        判断密码正确性
        if (!user.getPassword().equals(password)) {
            String html = "<h3>密码错误</h3>";
            response.getWriter().write(html);
            return;
        }
//        行文至此，已经说明登录正确了
//        设置会话
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
//        重定向至列表页
        response.sendRedirect("blog_list.html");
    }

    /**
     * 动态渲染列表页
     */
    @GetMapping("/blog")
    @ResponseBody
    public List<Blog> blogList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //        检查是否登录
        User user1 = util.checkLoginStatus(request);
        if (user1 == null) {
            response.setStatus(403);
            return null;
        }
//        查询所有博客信息
        List<Blog> blogs = blogMapper.selectAllBlog();
        return blogs;
    }

    /**
     * 动态渲染用户信息和详情页作者信息
     */
    @GetMapping("/user")
    @ResponseBody
    public User UserInfo(HttpServletRequest request, HttpServletResponse response) {
        //  获取blogId
        String blogId = request.getParameter("blogId");
        //根据是否获得blogId来判断到底是列表页还是详情页
        if (blogId == null) {
            // 说明是列表页 获得登录用户信息
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("user");
            return user;
        } else {
            // 说明是详情页 获得作者信息
            Blog blog = blogMapper.selectByBlogId(Integer.parseInt(blogId));
            User anthor = userMapper.selectUserById(blog.getUserId());
            return anthor;
        }
    }

    /**
     * 列表页 --> 详情页 逻辑
     */
    @GetMapping("/detail")
    @ResponseBody
    public Blog blogDetail(Integer blogId, HttpServletRequest request, HttpServletResponse response) {
        //        检查是否登录
        User user1 = util.checkLoginStatus(request);
        if (user1 == null) {
            response.setStatus(403);
            return null;
        }
        Blog blog = blogMapper.selectByBlogId(blogId);
        return blog;
    }

    /**
     * 编辑页
     */
    @PostMapping("/blog_edit")
    @ResponseBody
    public void editBlod(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //  检查是否登录
        User user = util.checkLoginStatus(request);
        if (user == null) {
            response.getWriter().write("<h1>未登录！不能发布博客</h1>");
            return;
        }
//        获取参数
        String title = request.getParameter("title");
        String content = request.getParameter("content");
//        判断参数合法性
        if (title==null || title.equals("") || content==null || content.equals("")) {
            response.getWriter().write("文章标题或正文不能为空");
            response.sendRedirect("blog_edit.html");
            return;
        }
        Blog blog = new Blog();
        blog.setContent(content);
        blog.setTitle(title);
        blog.setPostTime(new Timestamp(System.currentTimeMillis()));
        blog.setUserId(user.getUserId());
        blogMapper.addBlog(blog);
        response.sendRedirect("blog_list.html");
    }


    //  注销是删除session
    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession(false);
        session.removeAttribute("user");
        response.sendRedirect("blog_login.html");
    }
}
