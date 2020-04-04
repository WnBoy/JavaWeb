package com.xupt.dao;

import com.xupt.pojo.Order;

import java.util.List;

/**
 * @author Wnlife
 * @create 2020-03-31 20:11
 */
public interface OrderDao {
    public int saveOrder(Order order);
    public List<Order> queryOrders();
}
