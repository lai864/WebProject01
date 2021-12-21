package com.hello_world.web;

import com.hello_world.pojo.Cart;
import com.hello_world.pojo.User;
import com.hello_world.service.OrderService;
import com.hello_world.service.impl.OrderServiceImpl;
import com.hello_world.utils.DBUtil;
import com.hello_world.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet{
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建一个订单需要购物车和用户id
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");
        //如果用户没登录，跳到登录页面
        if (user==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer userId = user.getId();

        //生成订单
        String orderId = orderService.createOrder(cart, userId);

//        req.setAttribute("orderId",orderId);
        req.getSession().setAttribute("orderId",orderId);

        // 请求转发
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
