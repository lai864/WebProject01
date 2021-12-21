package com.hello_world.test;

import com.hello_world.pojo.User;
import com.hello_world.service.UserService;
import com.hello_world.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"bbj","123","bbj.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"chen","123456",null)));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("bbj")){
            System.out.println("用户名已存在");
        }else {
            System.out.println("用户名可用");
        }
    }
}