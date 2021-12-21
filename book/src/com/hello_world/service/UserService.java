package com.hello_world.service;

import com.hello_world.pojo.User;

public interface UserService {
    //注册用户
    void registerUser(User user);

    //登录
    User login(User user);

    //查看用户名是否存在
    boolean existsUsername(String username);
}
