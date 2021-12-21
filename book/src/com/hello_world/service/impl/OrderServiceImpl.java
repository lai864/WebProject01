package com.hello_world.service.impl;

import com.hello_world.dao.BookDao;
import com.hello_world.dao.OrderDao;
import com.hello_world.dao.OrderItemDao;
import com.hello_world.dao.impl.BookDaoImpl;
import com.hello_world.dao.impl.OrderDaoImpl;
import com.hello_world.dao.impl.OrderItemDaoImpl;
import com.hello_world.pojo.*;
import com.hello_world.service.OrderService;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis()+""+userId;
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);

        //保存订单:用户得到订单信息，商家在数据库得到订单号相同的多个订单项
        orderDao.saveOrder(order);
//            int i = 12/0;
        //遍历购物车里的每个商品项，装换为订单项
        Set<Map.Entry<Integer, CartItem>> entries = cart.getItems().entrySet();
        for (Map.Entry<Integer, CartItem> map : entries) {
            //获取每一个购物车里的商品项
            CartItem cartItem = map.getValue();
            //把每一个商品项转为订单项
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            //保存到数据库
            orderItemDao.saveOrderItem(orderItem);


            //更改库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.update(book);
        }

        cart.clear();
        return orderId;
    }
}
