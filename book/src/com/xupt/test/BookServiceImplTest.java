package com.xupt.test;

import com.xupt.pojo.Book;
import com.xupt.pojo.Page;
import com.xupt.service.BookService;
import com.xupt.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Wnlife
 * @create 2020-03-25 17:54
 */
public class BookServiceImplTest {

    BookService bookService=new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"headfirstjava","谢爽",new BigDecimal(100),50,20,null));
    }

    @Test
    public void deleteBook() {
        bookService.deleteBook(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(1,"java从入门到不放弃","强强强",new BigDecimal(200),200,200,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(1));
    }

    @Test
    public void queryBooks() {
        bookService.queryBooks().stream().forEach(System.out::println);
    }
    @Test
    public void pageByPrice(){
        Page<Book> bookPage = bookService.pageByPrice(1, Page.PAGE_SIZE, 10, 50);
        System.out.println(bookPage.toString());
    }
}