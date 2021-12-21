package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("执行Servlet构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("执行init初始化方法");
        //1.可以获取Servlet程序的别名，servlet-name值
        System.out.println(servletConfig.getServletName());
        //2.可以获取初始化参数init-param
        System.out.println(servletConfig.getInitParameter("username"));
        System.out.println(servletConfig.getInitParameter("url"));
        //3.可以ServletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("执行service方法==Servlet被访问了");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if ("POST".equals(method)){
            doPost();
        }else if ("GET".equals(method)){
            doGet();
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("执行destroy方法");
    }

    public void doGet(){
        System.out.println("执行了GET提交方法");
        System.out.println("执行了GET提交方法");
        System.out.println("执行了GET提交方法");
        System.out.println("执行了GET提交方法");
        System.out.println("执行了GET提交方法");
        System.out.println("执行了GET提交方法");
        System.out.println("执行了GET提交方法");
    }

    public void doPost(){
        System.out.println("执行了POST提交方法");
        System.out.println("执行了POST提交方法");
        System.out.println("执行了POST提交方法");
        System.out.println("执行了POST提交方法");
        System.out.println("执行了POST提交方法");
        System.out.println("执行了POST提交方法");
    }
}
