package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends BaseServlet{


    protected void saveLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("chen".equals(username) && "123456".equals(password)){
            Cookie cookie = new Cookie(username,username);
            cookie.setMaxAge(60*60*24*7);//设置用户免登入时间为7天
            resp.addCookie(cookie);//让浏览器保存cookie对象
            //密码保存
//            Cookie cookie2 = new Cookie(password,password);
//            cookie2.setMaxAge(60*60*24*7);
//            resp.addCookie(cookie2);
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }

    }
}
