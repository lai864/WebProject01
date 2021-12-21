package com.hello_world.dao.impl;

import com.hello_world.dao.BaseDao;
import com.hello_world.dao.OrderItemDao;
import com.hello_world.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(name,count,price,total_price,order_id) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
