package com.hello_world.filter;

import com.hello_world.utils.DBUtil;
import com.hello_world.utils.WebUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            filterChain.doFilter(servletRequest,servletResponse);//间接执行了servlet程序的方法，访问到配置范围的资源，会层层回到filter程序，最后回到浏览器
            DBUtil.commitAndClose();//提交事务，并关闭连接

        } catch (Exception e) {
            DBUtil.rollbackAndClose();//回滚事务，并关闭连接
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
