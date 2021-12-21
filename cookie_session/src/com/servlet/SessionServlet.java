package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet{

    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取Session，同一个API
        HttpSession session = req.getSession();
        //判断是否是第一次创建的Session
        boolean aNew = session.isNew();
        //获取Session的id
        String id = session.getId();

        //在浏览器输出
        resp.getWriter().write("session的信息<br>");
        resp.getWriter().write("是否是新创建的Session:"+aNew+"<br>");
        resp.getWriter().write("session的id="+id+"<br>");
    }

    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1","value1");
        resp.getWriter().write("session域中已经存放了数据");
    }


    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object value1 = req.getSession().getAttribute("key1");
        resp.getWriter().write("session域中取出值="+value1);
    }


    protected void sessionDefaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //默认生命周期
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("session的默认超时时间是："+maxInactiveInterval+"秒");
    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置session超时时间为3秒
        req.getSession().setMaxInactiveInterval(3);
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("session设置的超时时间是："+maxInactiveInterval+"秒");

    }


    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //设置session马上超时（设置为是超时的）
        session.invalidate();
        resp.getWriter().write("session会话被设置为超时");
    }
}
