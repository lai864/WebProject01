package com.hello_world.web;
//前台内容给用户浏览，manager是后台内容，客户不能浏览
import com.hello_world.pojo.Book;
import com.hello_world.pojo.Page;
import com.hello_world.service.BookService;
import com.hello_world.service.impl.BookServiceImpl;
import com.hello_world.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ClientServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo+=1;//永远添加后到，跳到最后一页
        bookService.addBook(book);
        /*表单重复提交
    当用户提交完请求，浏览器会记录下最后一次请求的全部信息，当用户按下功能键F5，就会发起浏览器的最后一次请求
        所以要使用转发重定向，而不是请求转发*/
        // System.out.println(req.getContextPath()); /book   特殊情况：response.sendRediect("/") 把斜杆/发送给浏览器解析，得到http://ip:port
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        bookService.deleteBookById(id);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));//这里访问bookServlet程序，而不是网页，之后list方法访问网页
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.update(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0); //在get请求地址栏：name=value
        Book book = bookService.queryBookById(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    //page的作用是对查询到的数据分页，显示在网页，增删改方法请求要传递页码
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数，pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.调用BookService.page(pageNo,pageSize):page对象
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("client/bookServlet?action=page");
        //3.保存Page对象到Request域中
        req.setAttribute("page",page);
        //4.请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数，pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
    int min = WebUtils.parseInt(req.getParameter("min"), 0);
    int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
    //2.调用BookService.page(pageNo,pageSize):page对象
        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);
        //将价格区间添加到url地址
    StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
    if (req.getParameter("min")!=null){
        sb.append("&min=").append(req.getParameter("min"));
    }
    if (req.getParameter("max")!=null){
        sb.append("&max=").append(req.getParameter("max"));
    }
        page.setUrl(sb.toString());
        //3.保存Page对象到Request域中
        req.setAttribute("page",page);
        //4.请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过BookService查询到全部图书
        List<Book> books = bookService.queryBooks();
        //将全部数据存储在request域中
        req.setAttribute("books", books);
        //通过Servlet程序请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

}
