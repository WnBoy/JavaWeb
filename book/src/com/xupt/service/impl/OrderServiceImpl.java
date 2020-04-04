package com.xupt.service.impl;

import com.xupt.dao.BookDao;
import com.xupt.dao.OrderDao;
import com.xupt.dao.OrderItemDao;
import com.xupt.dao.impl.BookDaoImpl;
import com.xupt.dao.impl.OrderDaoImpl;
import com.xupt.dao.impl.OrderItemDaoImpl;
import com.xupt.pojo.*;
import com.xupt.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Wnlife
 * @create 2020-03-31 20:58
 */
public class OrderServiceImpl implements OrderService {
    OrderDao orderDao=new OrderDaoImpl();
    OrderItemDao orderItemDao=new OrderItemDaoImpl();
    BookDao bookDao=new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        //订单ID
        String id=System.currentTimeMillis()+""+userId;
        Order order = new Order(id, new Date(), cart.getTotalPrice(), 0, userId);
//        int a=1/0;
        orderDao.saveOrder(order);
        //将购物车里面的购物项变为订单项，保存到数据库
        for (Map.Entry<Integer,CartItem>entry:cart.getItems().entrySet()){
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), id);
            orderItemDao.saveOrderItem(orderItem);
            //更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }
        //清空购物车
        cart.clear();
        return id;
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDao.queryOrders();
    }
}
