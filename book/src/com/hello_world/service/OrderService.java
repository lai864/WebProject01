package com.hello_world.service;

import com.hello_world.pojo.Cart;

public interface OrderService {
    String createOrder(Cart cart,Integer useId);
}
