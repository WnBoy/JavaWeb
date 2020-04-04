package com.xupt.test;

import com.xupt.pojo.Cart;
import com.xupt.pojo.CartItem;
import com.xupt.service.OrderService;
import com.xupt.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Wnlife
 * @create 2020-03-31 22:05
 */
public class OrderServiceImplTest {

    @Test
    public void createOrder() {
        OrderService orderService = new OrderServiceImpl();
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java 从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java 从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100), new BigDecimal(100)));
        String id = orderService.createOrder(cart, 1);
        System.out.println(id);

    }
}