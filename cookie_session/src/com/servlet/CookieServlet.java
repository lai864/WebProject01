package com.servlet;

import com.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {


    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建Cookie
        Cookie cookie = new Cookie("key1", "value1");//键相同，值被后面覆盖
        Cookie cookie2 = new Cookie("key2", "value2");
        Cookie cookie3 = new Cookie("key3", "value3");
        //通知客户端保存Cookie
        resp.addCookie(cookie);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);

        resp.getWriter().write("Cookie被创建了");

    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            //getName()返回Cookie的名称，getValue返回Cookie的值
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "]<br/>");
        }

        //寻找特定的Cookie
        Cookie iWantCookie = CookieUtils.findCookie("key1", cookies);
        if (iWantCookie != null) {
            resp.getWriter().write("Cookie找到了");
        }
    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //方法1：
        Cookie cookie = new Cookie("key1", "newValue");
        resp.addCookie(cookie);
        resp.getWriter().write("Cookie被修改了<br/>");

        //方法二：
        Cookie iWantCookie = CookieUtils.findCookie("key2", req.getCookies());
        if (iWantCookie != null) {
            iWantCookie.setValue("newValue2");
        }
        resp.addCookie(iWantCookie);
        resp.getWriter().write("Cookie2被修改了");
    }

    //Cookie的生命周期设置,对已存在或刚创建的cookie都要做resp.addCookie()操作
    protected void cookieLife3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.负数：关闭浏览器，cookie被销毁删除，默认-1
        Cookie cooke1 = CookieUtils.findCookie("key1", req.getCookies());
        if (cooke1 != null) {
            cooke1.setMaxAge(-1);
            resp.addCookie(cooke1);
            resp.getWriter().write("创建了一个默认不关浏览器就不销毁的cookie<br/>");
        }

        //2.零，立即被删除，这就是删除cookie操作
        Cookie cooke2 = CookieUtils.findCookie("key2", req.getCookies());
        if (cooke2 != null) {
            cooke2.setMaxAge(0);
            resp.addCookie(cooke2);
            resp.getWriter().write("cookie2的值被删除了<br/>");
        }

        //3.正数，可存活的时间
        Cookie cooke3 = CookieUtils.findCookie("key3", req.getCookies());
        if (cooke3 != null) {
            cooke3.setMaxAge(60 * 60);//设置cookie存活一小时
            resp.addCookie(cooke3);
            resp.getWriter().write("创建了一个存活一小时的cookie");
        }
    }

    //设置能被服务器访问的cookie，工程目录必须相同，不能在工程地址下访问abc目录下的cookie，但在/工程地址/abc下工程地址下的cookie，即能访问上层目录下的cookie，不能访问下层目录下的
    protected void setPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie1 = new Cookie("path1","path1");
            cookie1.setPath(req.getContextPath()+"/abc/");
            resp.addCookie(cookie1);
            resp.getWriter().write("设置了在工程abc目录下能被创建的cookie");

    }
}
