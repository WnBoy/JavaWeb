package com.xupt.service;

import com.xupt.pojo.Cart;
import com.xupt.pojo.Order;

import java.util.List;

/**
 * @author Wnlife
 * @create 2020-03-31 20:52
 */
public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
    public List<Order> showAllOrders();
}
