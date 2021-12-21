package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置服务器编码集为UTF-8,服务器默认使用ISO=88S9-1，不能显示中文
//        resp.setCharacterEncoding("UTF-8");

        //还有设置浏览器编码集与服务器一致
//        resp.setHeader("Content-type","text/html;charset=UTF-8");

        //一次性设置服务器与客户端的编码集相一致
        resp.setContentType("text/html;charset=UTF-8"); //必须放在获取流之前 resp.getWriter();

        PrintWriter writer = resp.getWriter();
        writer.write("巨魔叔叔");
    }
}
