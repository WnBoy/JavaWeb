package com.xupt.test;

import com.xupt.dao.OrderDao;
import com.xupt.dao.impl.OrderDaoImpl;
import com.xupt.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Wnlife
 * @create 2020-03-31 20:28
 */
public class OrderDaoImplTest {
    OrderDao orderDao=new OrderDaoImpl();
    @Test
    public void saveOrder() {
        int saveOrder = orderDao.saveOrder(new Order("sdas", new Date(), new BigDecimal(123), 1, 1));
        System.out.println(saveOrder);
    }

    @Test
    public void queryOrders() {
        List<Order> orders = orderDao.queryOrders();
        System.out.println(orders);
    }
}