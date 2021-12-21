package com.hello_world.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    //    private Integer totalCount;
//    private BigDecimal totalPrice;
    private Map<Integer, CartItem> items = new HashMap<Integer, CartItem>();

    public Cart() {
    }

    //添加商品
    public void addItem(CartItem cartItem) {
        //根据商品ID作为键，得到值，商品
        CartItem item = items.get(cartItem.getId());
        //判断商品是否为空，为空直接加入购物车，同一个商品：单个商品和多个商品的区别是数量和，总价改变
        if (item == null) {
            items.put(cartItem.getId(), cartItem);
        } else {
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    //删除商品
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    //清空购物车
    public void clear() {
        items.clear();
    }

    //修改商品数量
    public void updateCount(Integer id, Integer count) {
        CartItem cartItem = items.get(id);
        //判断商品是否为空，为空修改商品数量，同一个商品：单个商品和多个商品的区别是数量和，总价改变
        if (cartItem != null) {
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;

        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());//BigDecimal类型的数据用方法加减乘除
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
