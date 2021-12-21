package com.hello_world.test;

import com.hello_world.dao.OrderItemDao;
import com.hello_world.dao.impl.OrderItemDaoImpl;
import com.hello_world.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao  = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100),"12345678900"));
        orderItemDao.saveOrderItem(new OrderItem(null,"cpp从入门到精通",1,new BigDecimal(100),new BigDecimal(100),"12345678900"));
        orderItemDao.saveOrderItem(new OrderItem(null,"python从入门到精通",1,new BigDecimal(100),new BigDecimal(100),"12345678900"));
    }
}