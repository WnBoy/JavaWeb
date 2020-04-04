package com.xupt.test;

import com.xupt.dao.OrderItemDao;
import com.xupt.dao.impl.OrderItemDaoImpl;
import com.xupt.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Wnlife
 * @create 2020-03-31 20:44
 */
public class OrderItemDaoImplTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao=new OrderItemDaoImpl();
        int orderItem = orderItemDao.saveOrderItem(new OrderItem(1, "sb", 12, new BigDecimal(20), new BigDecimal(300), "sdas"));
        System.out.println(orderItem);
    }
}