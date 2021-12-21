package com.hello_world.service.impl;

import com.hello_world.dao.UserDao;
import com.hello_world.dao.impl.UserDaoImpl;
import com.hello_world.pojo.User;
import com.hello_world.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.insert(user);
    }

    @Override
    public User login(User user) {
       return userDao.queryByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryByUsername(username)==null){
            return false;
        }else {
            return true;
        }
    }
}
