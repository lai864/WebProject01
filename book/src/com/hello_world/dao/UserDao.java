package com.hello_world.dao;

import com.hello_world.dao.BaseDao;
import com.hello_world.pojo.User;

public interface UserDao{
    //查询用户信息通过用户名
    User queryByUsername(String username);

    //查询用户信息通过用户名和密码
    User queryByUsernameAndPassword(String username,String password);


    //插入注册用户信息
    int insert(User user);

}


