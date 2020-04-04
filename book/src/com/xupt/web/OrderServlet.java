package com.xupt.web;

import com.xupt.pojo.Cart;
import com.xupt.pojo.Order;
import com.xupt.pojo.User;
import com.xupt.service.OrderService;
import com.xupt.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Wnlife
 * @create 2020-03-31 22:20
 */
public class OrderServlet extends BaseServlet {

    OrderService orderService = new OrderServiceImpl();

    /**
     * 创建订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {//如果用户没有登录,请求转发到登录页面’
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        //登录成功则保存数据到数据库，生成订单
        String orderID = orderService.createOrder(cart, loginUser.getId());

        //将orderID保存到session中
        req.getSession().setAttribute("orderID", orderID);

        //重定向的cart.jsp页面
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }

    /**
     * 显示订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orderList = orderService.showAllOrders();
        req.setAttribute("orderList",orderList);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);
    }
}
