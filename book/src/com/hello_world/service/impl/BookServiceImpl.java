package com.hello_world.service.impl;

import com.hello_world.dao.BookDao;
import com.hello_world.dao.impl.BookDaoImpl;
import com.hello_world.pojo.Book;
import com.hello_world.pojo.Page;
import com.hello_world.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
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
        Page<Book> page = new Page<Book>();


        //设置每页显示的数量
        page.setPageSize(pageSize);

        //求总记录
        Integer pageTotalCount = bookDao.queryForPagTotalCount();

        //设置总记录数
        page.setPageTotalCount(pageTotalCount);

        //求总页码
        Integer pageTotal = pageTotalCount/pageSize;
        if (pageTotalCount%pageSize>0){
            pageTotal+=1;
        }

        //设置页码总数
        page.setPageTotal(pageTotal);


        //设置当前页码
        page.setPageNo(pageNo);

        //求当前页的索引数
        int begin = (page.getPageNo()-1)*pageSize;
        //求当前页数据
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
        //设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();


        //设置每页显示的数量
        page.setPageSize(pageSize);

        //求总记录
        Integer pageTotalCount = bookDao.queryForPagTotalCountByPrice(min,max);

        //设置总记录数
        page.setPageTotalCount(pageTotalCount);

        //求总页码
        Integer pageTotal = pageTotalCount/pageSize;
        if (pageTotalCount%pageSize>0){
            pageTotal+=1;
        }

        //设置页码总数
        page.setPageTotal(pageTotal);


        //设置当前页码
        page.setPageNo(pageNo);

        //求当前页的索引数
        int begin = (page.getPageNo()-1)*pageSize;
        //求当前页数据
        List<Book> items = bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        //设置当前页数据
        page.setItems(items);

        return page;
    }
}
