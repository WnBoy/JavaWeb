package com.xupt.dao.impl;

import com.xupt.dao.OrderItemDao;
import com.xupt.pojo.OrderItem;

/**
 * @author Wnlife
 * @create 2020-03-31 20:36
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql="insert into t_order_item(name,count,price,total_price,order_id)values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
