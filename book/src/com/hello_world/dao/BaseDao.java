package com.hello_world.dao;

import com.hello_world.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.*;
import java.util.List;

public abstract class BaseDao<T> {
    private QueryRunner qr = new QueryRunner();


    public int update(String sql,Object...parameters){
        Connection conn = null;
        try {
             conn = DBUtil.getConnection();
            int update = qr.update(conn, sql, parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<T> queryMulti(String sql,Class<T> clazz,Object...parameters){
        Connection conn = null;

        try {
            conn = DBUtil.getConnection();
            return qr.query(conn,sql,new BeanListHandler<T>(clazz),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public T querySingle(String sql,Class<T> clazz,Object...parameters){
        Connection conn = null;

        try {
            conn = DBUtil.getConnection();
            return qr.query(conn,sql,new BeanHandler<T>(clazz),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Object queryScalar(String sql,Object...parameters){
        Connection conn = null;

        try {
            conn = DBUtil.getConnection();
            return qr.query(conn, sql,new ScalarHandler(),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
