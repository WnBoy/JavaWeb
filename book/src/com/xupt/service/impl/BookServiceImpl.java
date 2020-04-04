package com.xupt.service.impl;

import com.xupt.dao.BookDao;
import com.xupt.dao.impl.BookDaoImpl;
import com.xupt.pojo.Book;
import com.xupt.pojo.Page;
import com.xupt.service.BookService;

import java.util.List;

/**
 * @author Wnlife
 * @create 2020-03-25 17:51
 */
public class BookServiceImpl implements BookService {

    BookDao bookDao=new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> bookPage = new Page<>();
        bookPage.setPageSize(pageSize);
        //计算总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        //设置总记录数
        bookPage.setPageTotalCount(pageTotalCount);
        //计算总页数
        int pageTotal=pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0){
            pageTotal+=1;
        }
        //设置总页数
        bookPage.setPageTotal(pageTotal);
        //设置当前页码
        bookPage.setPageNo(pageNo);
        //计算begin
        int begin=(bookPage.getPageNo()-1)*pageSize;
        //计算当前页的数据
        List<Book> items = bookDao.queryBookItems(begin, pageSize);
        //设置当前页的数据
        bookPage.setItems(items);
        //返回对象
        return bookPage;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> bookPage = new Page<>();
        bookPage.setPageSize(pageSize);
        //计算总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        //设置总记录数
        bookPage.setPageTotalCount(pageTotalCount);
        //计算总页数
        int pageTotal=pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0){
            pageTotal+=1;
        }
        //设置总页数
        bookPage.setPageTotal(pageTotal);
        //设置当前页码
        bookPage.setPageNo(pageNo);
        //计算begin
        int begin=(bookPage.getPageNo()-1)*pageSize;
        //计算当前页的数据
        List<Book> items = bookDao.queryBookItemsByPrice(begin, pageSize,min,max);
        //设置当前页的数据
        bookPage.setItems(items);
        //返回对象
        return bookPage;
    }
}
