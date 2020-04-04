package com.xupt.test;

import com.xupt.dao.BookDao;
import com.xupt.dao.impl.BookDaoImpl;
import com.xupt.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Wnlife
 * @create 2020-03-25 17:21
 */
public class BookDaoImplTest {
    BookDao bookDao=new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"headfirstjava","谢爽",new BigDecimal(100),50,20,null));
    }

    @Test
    public void deleteBook() {
        bookDao.deleteBook(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(1,"java从入门到放弃","强哥",new BigDecimal(100),100,100,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(1));
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        books.stream().forEach(System.out::println);
    }

    @Test
    public void queryForPageTotalCountByPrice(){
        System.out.println(bookDao.queryForPageTotalCountByPrice(10, 50));
    }
    @Test
    public void queryBookItemsByPrice(){
        List<Book> books = bookDao.queryBookItemsByPrice(0, 4, 10, 50);
        books.stream().forEach(System.out::println);
    }
}