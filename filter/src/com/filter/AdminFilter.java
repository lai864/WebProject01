package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //初始化方法
        System.out.println("获取Filter的名称 Filter-name的内容："+filterConfig.getFilterName());
        System.out.println("获取在Filter中web.xml配置的init-param初始化信息"+filterConfig.getInitParameter("username"));
        System.out.println("获取在Filter中web.xml配置的init-param初始化信息"+filterConfig.getInitParameter("password"));
        System.out.println("获取ServletContext对象"+filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Object user = httpServletRequest.getSession().getAttribute("user");
        if (user==null){
            servletRequest.getRequestDispatcher("/admin/login.jsp").forward(servletRequest,servletResponse);
            return;
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
