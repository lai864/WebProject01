package com.hello_world.test;

import com.hello_world.dao.OrderDao;
import com.hello_world.dao.impl.OrderDaoImpl;
import com.hello_world.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("12345678900",new Date(),new BigDecimal(35),0,10));
    }
}