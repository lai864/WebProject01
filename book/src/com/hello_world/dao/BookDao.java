package com.hello_world.dao;

import com.hello_world.pojo.Book;

import java.util.List;

public interface BookDao {
    int addBook(Book book);

    int deleteBookById(Integer id);

    int update(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Integer queryForPagTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPagTotalCountByPrice(int min, int max);


    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
