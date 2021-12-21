package com.hello_world.service;

import com.hello_world.pojo.Book;
import com.hello_world.pojo.Page;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    void addBook(Book book);

    void deleteBookById(Integer id);

    void update(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min,int max);
}
