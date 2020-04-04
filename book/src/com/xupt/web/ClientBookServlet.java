package com.xupt.web;

import com.xupt.pojo.Book;
import com.xupt.pojo.Page;
import com.xupt.service.BookService;
import com.xupt.service.impl.BookServiceImpl;
import com.xupt.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wnlife
 * @create 2020-03-26 22:48
 */
public class ClientBookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    /**
     * 分页的方法
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.调用service查询page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        //3.设置URL
        page.setUrl("client/bookServlet?action=page");
        //4.放置到域对象中
        req.setAttribute("page", page);
        //5.页面跳转到/pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取参数pageNo,pageSize,min,max
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"),0);
        int max = WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
        //2.调用service查询page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize,min,max);
        //3.设置URL
        StringBuilder sb=new StringBuilder("client/bookServlet?action=pageByPrice");
        //如果请求参数里面有min
        if(req.getParameter("min")!=null){
            sb.append("&min=").append(req.getParameter("min"));
        }
        //如果请求参数里面有max
        if(req.getParameter("max")!=null){
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
        //4.放置到域对象中
        req.setAttribute("page", page);
        //5.页面跳转到/pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);

    }

}
