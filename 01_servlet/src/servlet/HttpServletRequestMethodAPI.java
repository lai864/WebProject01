package servlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class HttpServletRequestMethodAPI  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        getRequestURI()     获取请求的资源路径
        System.out.println("URI =>"+req.getRequestURI());
//        getRequestURL()     获取请求的统一资源定位符（绝对路径）
        System.out.println("URL =>"+req.getRequestURL());
//        getRemoteHost()    获取客户端的ip地址
        System.out.println("客户端的ip地址 =>"+req.getRemoteHost());
//        getHeader()         获取请求头
        System.out.println("请求头User-Agent =>"+req.getHeader("User-Agent"));
//        getParameter()      获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("请求的参数 =>"+username);
        System.out.println("请求的参数 =>"+password);
//        getParameterValues() 获取请求的参数（多个值的时候用）
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println("多个请求参数 =>"+ Arrays.asList(hobbies));
//        getMethod()         获取请求的方式GET或POST
        System.out.println("请求的方式 =>"+req.getMethod());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //POST请求有乱码问题，设置UTF-8字符集
        req.setCharacterEncoding("UTF-8");
        System.out.println("++++++++++++++doPost+++++++++++++++++");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("请求的参数 =>"+username);
        System.out.println("请求的参数 =>"+password);
//        getParameterValues() 获取请求的参数（多个值的时候用）
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println("多个请求参数 =>"+ Arrays.asList(hobbies));
    }
}
