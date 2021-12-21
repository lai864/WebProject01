package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet2 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //必须调用父类方法，否则被子类同名方法覆盖，执行失败
        System.out.println("config做了些事");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行HelloServlet2的doGet方法");

        ServletConfig servletConfig = getServletConfig();
        //1.可以获取Servlet程序的别名，servlet-name值
        System.out.println(servletConfig.getServletName());
        //2.可以获取初始化参数init-param
        System.out.println(servletConfig.getInitParameter("username"));
        System.out.println(servletConfig.getInitParameter("url"));
        //3.可以ServletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行HelloServlet2的doPost方法");
    }
}
