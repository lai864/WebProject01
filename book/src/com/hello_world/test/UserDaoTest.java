package com.hello_world.test;
//Ctrl+Shift+t 在要测试的方法的类的空白处，生成测试类
import com.hello_world.dao.UserDao;
import com.hello_world.dao.impl.UserDaoImpl;
import com.hello_world.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void queryByUsername() {
        UserDao userDao = new UserDaoImpl();
        if (userDao.queryByUsername("chen")==null){
            System.out.println("!用户名可用");
        }else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryByUsernameAndPassword() {
        UserDao userDao = new UserDaoImpl();
      if (userDao.queryByUsernameAndPassword("chen","123456")==null){
          System.out.println("用户名或密码错误，登录失败");
      }else {
          System.out.println("查询成功");
      }
    }

    @Test
    public void insert() {
        UserDao userDao = new UserDaoImpl();
        int insert = userDao.insert(new User(null,"main", "main", ",main"));
    }
}