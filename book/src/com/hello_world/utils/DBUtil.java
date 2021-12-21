package com.hello_world.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    private static DruidDataSource dataSource;
//private static DataSource dataSource;
    private static ThreadLocal<Connection> conns =  new ThreadLocal<Connection>();

    static {
        try {
            Properties prop = new Properties();
            //读取jdbc.properties属性配置文件
            InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            prop.load(inputStream);
//            prop.load(new FileInputStream("book\\src\\jdbc.properties"));
            //创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);
//            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DBUtil() {
    }

    public static Connection getConnection(){
        Connection conn = conns.get();
            try {
                if (conn == null) {
                    conn = dataSource.getConnection();//从数据库连接池里获取连接
                    conns.set(conn);//保存到ThreadLocal到对象中，供后面的jdbc操作使用
                    conn.setAutoCommit(false);//修改为手动管理事务
                }
            }catch (Exception e){
                e.printStackTrace();
            }


        return conn;
    }

    public static void commitAndClose(){
        Connection connection = conns.get();
            if (connection != null) { //如果连接对象不为空，说明操作了连接对象
                try {
                    connection.commit();//提交事务
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        connection.close();//关闭连接，释放资源
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            //一定要清空ThreadLocal对象，数据库底层有用到ThreadLocal
            conns.remove();
    }
    public static void rollbackAndClose(){
            Connection connection = conns.get();
                if (connection != null) { //如果连接对象不为空，说明操作了连接对象
                    try {
                        connection.rollback();//回滚事务
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            connection.close();//关闭连接，释放资源
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
        conns.remove();
        }


  /*    public static void close(Connection conn, Statement stmt, ResultSet rs) {
//        if (rs != null) {
//            try {
//                rs.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        if (stmt != null) {
//            try {
//                stmt.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {

                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


   */
}
