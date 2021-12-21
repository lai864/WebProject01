package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取web.xml中配置的上下文参数context-param
        ServletContext context = getServletConfig().getServletContext();
        System.out.println("context-param参数username的值是:"+context.getInitParameter("username"));
        System.out.println("context-param参数password的值是:"+context.getInitParameter("password"));
        //2.获取当前工程路径， 格式：/工程路径，即Tomcat分配的artifact
        System.out.println("当前工程路径："+context.getContextPath());
        //3.获取工程部署后在服务器硬盘上的绝对路径
        System.out.println("工程部署的路径:"+context.getRealPath("/css"));
        //D:\IUPO\IdeaJavaWebProjects\WebProject01\out\artifacts\Web_war_exploded\css
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
