package com.xupt.web;

import com.google.gson.Gson;
import com.xupt.pojo.Book;
import com.xupt.pojo.Cart;
import com.xupt.pojo.CartItem;
import com.xupt.service.BookService;
import com.xupt.service.impl.BookServiceImpl;
import com.xupt.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wnlife
 * @create 2020-03-31 15:17
 */
public class CartServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();

    /**
     * Ajax实现商品添加到购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ID
        int booId = WebUtils.parseInt(req.getParameter("booId"), 0);
        //查询书的信息
        Book book = bookService.queryBookById(booId);
        //将book转换为cartItem
        CartItem item = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //从session获取购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        //添加到购物车
        cart.addItem(item);
        System.out.println(cart);

        //将totalCount和lastName转为json发送到购物车
        Map<String,Object>map=new HashMap<>();
        map.put("totalCount",cart.getTotalCount());
        map.put("lastName",item.getName());
        Gson gson = new Gson();
        String json = gson.toJson(map);
        resp.getWriter().write(json);
    }


    /**
     * 添加到购物车
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ID
        int booId = WebUtils.parseInt(req.getParameter("booId"), 0);
        //查询书的信息
        Book book = bookService.queryBookById(booId);
        //将book转换为cartItem
        CartItem item = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //从session获取购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        //添加到购物车
        cart.addItem(item);
        System.out.println(cart);

        //将最后一个商品的信息添加到购物车
        req.getSession().setAttribute("lastName",item.getName());
        //重定向会原来页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 删除购物项
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.deleteItem(id);
        //返回原页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 清空购物车
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clearCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            //返回原页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 修改商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count = WebUtils.parseInt(req.getParameter("count"), 0);
        int id = WebUtils.parseInt(req.getParameter("id"), 1);

        Cart cart= (Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.updateCount(id,count);
            //返回原页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
