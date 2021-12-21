package com.hello_world.web;

import com.hello_world.pojo.User;
import com.hello_world.service.UserService;
import com.hello_world.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (userService.login(new User(null,username,password,null))==null){
            System.out.println("密码["+password+"]或用户名["+username+"]错误");
            //登录失败，重新转跳到登录页面
            //一次请求，设置请求域，封装错误信息，并保留上次输入的信息
            req.setAttribute("Msg","用户名或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            System.out.println("密码["+password+"]或用户名["+username+"]正确");
            //登录成功，转跳到登录成功页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
