package com.xupt.dao;

import com.xupt.pojo.Book;

import java.util.List;

/**
 * @author Wnlife
 * @create 2020-03-25 16:02
 */
public interface BookDao {

    public int addBook(Book book);

    public int deleteBook(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Integer queryForPageTotalCount();

    public List<Book> queryBookItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryBookItemsByPrice(int begin, int pageSize, int min, int max);
}
