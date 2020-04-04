package com.xupt.service;

import com.xupt.pojo.Book;
import com.xupt.pojo.Page;

import java.util.List;

/**
 * @author Wnlife
 * @create 2020-03-25 17:45
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBook(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
