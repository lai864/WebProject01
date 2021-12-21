package com.hello_world.web;


import com.hello_world.pojo.User;
import com.hello_world.service.UserService;
import com.hello_world.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
   private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        if ("abcd".equalsIgnoreCase(code)){
            //检查用户名是否可用
            if (userService.existsUsername(username)){
                //用户名存在
                System.out.println("用户名["+username+"]已存在");
                //一次请求，设置请求域，封装错误信息
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.setAttribute("Msg","用户名已存在");
               // 重新跳转到注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else {
                //用户名可用，将注册信息录入数据库
                userService.registerUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);

            }
        }else {
            System.out.println("验证码["+code+"]错误");
            //验证码错误，重新跳转到注册页面
            //一次请求，设置请求域，保留上次输入的信息
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.setAttribute("Msg","验证码错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }

    }
}
