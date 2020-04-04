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
import java.util.List;

/**
 * @author Wnlife
 * @create 2020-03-25 18:31
 */
public class BookServlet extends BaseServlet {

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
        String pageNo = req.getParameter("pageNo");
        String pageSize = req.getParameter("pageSize");
        //2.调用service查询page对象
        Page<Book> page = bookService.page(WebUtils.parseInt(pageNo, 1), WebUtils.parseInt(pageSize, Page.PAGE_SIZE));
        //3.设置URL
        page.setUrl("manager/bookServlet?action=page");
        //4.放置到域对象中
        req.setAttribute("page", page);
        //5.页面跳转到/pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo += 1;
        Book book = WebUtils.copyParameter(req.getParameterMap(), new Book());
        bookService.addBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        bookService.deleteBook(id);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    /**
     * 修改是回显要修改的书的数据
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //查询出要修改的书的信息
        Book book = bookService.queryBookById(id);
        //把数据放到request域中回显
        req.setAttribute("book", book);
        //页面跳到/pages/manager/book_edit.jsp
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParameter(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        //跳转到查询列表
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }
}
