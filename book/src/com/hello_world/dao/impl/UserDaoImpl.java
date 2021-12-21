package com.hello_world.dao.impl;

import com.hello_world.dao.BaseDao;
import com.hello_world.dao.UserDao;
import com.hello_world.pojo.User;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public User queryByUsername(String username) {
        String sql = "select * from t_user where username=?";
        return querySingle(sql,User.class,username);
    }

    @Override
    public User queryByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username =? and password =?";
        return  querySingle(sql,User.class,username,password);
    }

    @Override
    public int insert(User user) {
        String sql = "insert into t_user(id,username,password,email) values(null,?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
