package com.hello_world.test;

import com.hello_world.dao.OrderItemDao;
import com.hello_world.dao.impl.OrderItemDaoImpl;
import com.hello_world.pojo.Cart;
import com.hello_world.pojo.CartItem;
import com.hello_world.pojo.OrderItem;
import com.hello_world.service.OrderService;
import com.hello_world.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {

        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"JAVAV从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"JAVAV从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"麦田里的守望者",1,new BigDecimal(1000),new BigDecimal(1000)));

        OrderService orderService = new  OrderServiceImpl();

        System.out.println("订单号是："+orderService.createOrder(cart,1));
    }
}