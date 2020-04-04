package com.xupt.dao.impl;

import com.xupt.dao.OrderDao;
import com.xupt.pojo.Order;

import java.util.List;

/**
 * @author Wnlife
 * @create 2020-03-31 20:14
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql="insert into t_order(order_id,create_time,price,status,user_id) values(?,?,?,?,?)";
        return update(sql,order.getOrder_id(),order.getCreate_time(),order.getPrice(),order.getStatus(),order.getUser_id());
    }

    @Override
    public List<Order> queryOrders() {
        String sql="SELECT * FROM t_order";
        return queryForList(Order.class,sql);
    }
}
