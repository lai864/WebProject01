package com.hello_world.web;

import com.google.gson.Gson;
import com.hello_world.pojo.User;
import com.hello_world.service.UserService;
import com.hello_world.service.impl.UserServiceImpl;
import com.hello_world.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean existsUsername = userService.existsUsername(username);
        Map<String,Object> map = new HashMap<>();
        map.put("existsUsername",existsUsername);
        Gson gson = new Gson();
        String mapJsonString = gson.toJson(map);
        resp.getWriter().write(mapJsonString);
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());
//        System.out.println(user);
        User loginUser = userService.login(new User(null, username, password, null));

        if (loginUser==null){
            System.out.println("密码["+password+"]或用户名["+username+"]错误");
            //登录失败，重新转跳到登录页面
            //一次请求，设置请求域，封装错误信息，并保留上次输入的信息
            req.setAttribute("Msg","用户名或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            System.out.println("密码["+password+"]或用户名["+username+"]正确");
            //登录成功，转跳到登录成功页面
            //创建session会话并保存登录用户信息
            req.getSession().setAttribute("user",loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //注销
        req.getSession().invalidate();//第一次创建session后在生命周期内是同一个session会话
        resp.sendRedirect(req.getContextPath());
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //获取验证码，jar包中有servlet程序生成验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //马上删除验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        if (token!=null && token.equalsIgnoreCase(code)){
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
