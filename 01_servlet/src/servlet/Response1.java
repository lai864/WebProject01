package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("response1到此一游");
        System.out.println("给爷爬");
        //浏览器地址栏发生改变
        //两次请求
        //不共享Request对象数据，因为请求了两次，是两个不同的Request对象
//        req.setAttribute("key","value");

        //给定状302态码表示废弃这个接口
//        resp.setStatus(302);

        //重定向，浏览器发送新的请求地址
//        resp.setHeader("Location","http://localhost:8080/01_servlet/response2");

        //不能访问WEB-INF目录下的内容
//        resp.setHeader("Location","http://localhost:8080/01_servlet/WEB-INF/1.html");
        //可以访问web工程以外的资源
//        resp.setHeader("Location","https://www.baidu.com");

        //重定向第二种方式（推荐使用）
        resp.sendRedirect("https://www.baidu.com");


    }
}
