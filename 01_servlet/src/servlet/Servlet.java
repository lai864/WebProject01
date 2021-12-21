package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("+++++++++++++++请求转发++++++++++++++++");
        //请求转发
        String username = req.getParameter("username");
        System.out.println("柜台1查看材料 =>"+username);
//        setAttribute(key,value) 设置域数据
        req.setAttribute("key","柜台1的章");
        //柜台2怎么走，去Servlet1
//      getRequestDispatcher() 获取请求转发对象

        /*请求转发特点：
         * 浏览器地址栏没有变化
         * 它们是一次请求
         * 它们共享Request域中的数据
         * 不能访问工程外的资源*/
        //请求转发能访问WEB-INF目录下的WEB文件，html等。可能需要重新打开Idea
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/1.html");
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet1");

        //还可以跳转到网页
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/a/b/c.html");

        //走向柜台2 servlet1
        requestDispatcher.forward(req,resp);




//        getAttribute(key)     获取域数据
//        System.out.println("获取域数据 =>"+req.getAttribute("我的任务"));


    }
}
