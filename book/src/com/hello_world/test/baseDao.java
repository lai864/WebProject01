package com.hello_world.test;

import com.hello_world.pojo.User;
import com.hello_world.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class baseDao {
    /*
    public static void main(String[] args) throws SQLException {
        //DQL查询语句
        System.out.println(baseDao.queryMany());
        System.out.println(baseDao.querySingle());
        System.out.println(baseDao.queryScalar());
        
        //DML增，删，改语句
        DML();
    }

    //查询得到多条语句，对应多个对象
    public static List<User> queryMany() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection coon = DBUtil.getConnection();
        String sql = "select * from t_user where id=?";
        List<User> list = queryRunner.query(coon, sql, new BeanListHandler<>(User.class),1);
        DBUtil.close(coon,null,null);
        return list;
    }

    //查询得到单条语句，对应一个对象
    public static User querySingle() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection coon = DBUtil.getConnection();
        String sql = "select * from t_user where username =? and password =?";
        User user = queryRunner.query(coon, sql, new BeanHandler<>(User.class), "chen", "123456");
        DBUtil.close(coon,null,null);
        return user;
    }

    //查询得到单条单列语句，对应一个对象的属性
    public static Object queryScalar() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection coon = DBUtil.getConnection();
        String sql = "select email from t_user where username =? and password =?";
        Object object = queryRunner.query(coon, sql, new ScalarHandler(), "chen", "123456");
        DBUtil.close(coon,null,null);
        return object;
    }
    
    //DML增，删，改语句,都是update()方法，得到影响条数
    public static void DML() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection coon = DBUtil.getConnection();
//        String sql = "insert into t_user(id,username,password,email) values(null,?,?,?)";
//        String sql = "update t_user set email=? where username=?";
        String sql = "delete from t_user where username=?";
        int affectedRow = queryRunner.update(coon, sql, "Jerry");
        System.out.println(affectedRow>0? "执行成功":"执行没有影响到表");
        DBUtil.close(coon,null,null);
    }

     */
}
