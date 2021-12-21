package com.hello_world.test;

import com.hello_world.utils.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilTest {
    public static void main(String[] args) {
//        try {
//            Connection conn = DBUtil.getConnection();
//            System.out.println(conn.getClass());
//            DBUtil.close(conn,null,null);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        Connection connect = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaWeb", "root", "123456");
        } catch (Exception e)
        {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
