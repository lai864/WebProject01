package com.hello_world.web;

import com.google.gson.Gson;
import com.hello_world.pojo.Book;
import com.hello_world.pojo.Cart;
import com.hello_world.pojo.CartItem;
import com.hello_world.service.BookService;
import com.hello_world.service.impl.BookServiceImpl;
import com.hello_world.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    //使用AJAX请求添加购物车
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //从Session中获得Cart对象，如果没有就创建
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart==null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

        //记录最后添加的商品名
        req.getSession().setAttribute("lastName",cartItem.getName());

        //返回购物车总的商品数量和最后添加的商品名称
        Map<String,Object> resultMap = new HashMap<String,Object>();

        resultMap.put("lastName",cartItem.getName());
        resultMap.put("totalCount",cart.getTotalCount());

        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);

        resp.getWriter().write(resultMapJsonString);
    }

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //从Session中获得Cart对象，如果没有就创建
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart==null){
            cart = new Cart();
           req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

        //能够记录请求过来的页面地址
        System.out.println("请求头Referer的值："+req.getHeader("Referer"));
        //记录最后添加的商品名
        req.getSession().setAttribute("lastName",cartItem.getName());

        //响应从定向到原来页面。记录的地址
        resp.sendRedirect(req.getHeader("Referer"));

    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            cart.deleteItem(id);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            cart.clear();
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            cart.updateCount(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
