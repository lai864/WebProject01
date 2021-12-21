package com.hello_world.dao.impl;

import com.hello_world.dao.BaseDao;
import com.hello_world.dao.OrderDao;
import com.hello_world.pojo.Order;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(order_id,create_time,price,status,user_id) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
