package com.filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("chen".equals(username)&&"123456".equals(password)){
            req.getSession().setAttribute("user",username);//session域中保存用户信息，表示登录了
            System.out.println("登录成功了");
        }else {
            req.getRequestDispatcher("/admin/login.jsp");
        }
    }
}
