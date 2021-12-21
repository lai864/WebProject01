package com.hello_world.test;

import com.hello_world.pojo.Book;
import com.hello_world.pojo.Page;
import com.hello_world.service.BookService;
import com.hello_world.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"稻田里的守望者","foreign",new BigDecimal(45),300,500,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(21);
    }

    @Test
    public void update() {
        bookService.update(new Book(21,"麦田里的守望者","foreign",new BigDecimal(45),300,500,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }

    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,10,50));
    }
}