package com.lanxiang.dao;


import com.lanxiang.model.User;

public interface UserDao {

    User loginUser(User user);

    int updateAddress(User user);

    User getAddress(User user);

    User getUser(User user);
}
