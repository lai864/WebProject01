package com.hello_world.dao.impl;

import com.hello_world.dao.BaseDao;
import com.hello_world.dao.BookDao;
import com.hello_world.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , ? , ? , ? , ? , ? , ?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id=?";
        return update(sql,id);
    }

    @Override
    public int update(Book book) {
        String sql = "update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where id=?";
        return querySingle(sql,Book.class,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book ";
        return queryMulti(sql,Book.class);
    }

    @Override
    public Integer queryForPagTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryScalar(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book limit ?,?";
        return queryMulti(sql,Book.class,begin,pageSize);
    }

    @Override
    public Integer queryForPagTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryScalar(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book " +
                "where price between ? and ? order by price limit ?,?";
        return queryMulti(sql,Book.class,min,max,begin,pageSize);
    }
}
