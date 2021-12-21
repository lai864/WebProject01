package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        System.out.println(context.getAttribute("保存前key1的值是："+"key1"));
        context.setAttribute("key1","value1");
        System.out.println("context中获取域数据key1的值是："+context.getAttribute("key1"));
        System.out.println("context中获取域数据key1的值是："+context.getAttribute("key1"));
        System.out.println("context中获取域数据key1的值是："+context.getAttribute("key1"));
        System.out.println("context中获取域数据key1的值是："+context.getAttribute("key1"));


//        null
//        null
//        context中获取域数据key1的值是：value1
//        context中获取域数据key1的值是：value1
//        context中获取域数据key1的值是：value1
//        context中获取域数据key1的值是：value1
//                value1
//        null
//        context中获取域数据key1的值是：value1
//        context中获取域数据key1的值是：value1
//        context中获取域数据key1的值是：value1
//        context中获取域数据key1的值是：value1

    }

}
