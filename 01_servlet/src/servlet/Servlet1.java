package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求转发到了第二个程序：处理请求参数
        String username = req.getParameter("username");
        System.out.println("柜台2处理的参数 =>"+username);

        //查看程序1是否盖好它的章
        //        getAttribute(key)     获取域数据
        System.out.println("获取域数据 =>"+req.getAttribute("key"));

        //Servlet1处理自己的业务
        System.out.println("Servlet1处理自己的业务");
    }
}
