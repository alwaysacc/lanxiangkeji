package com.lanxiang.dao;


import com.lanxiang.model.User;

import java.util.List;

public interface UserDao {

    User loginUser(User user);

    int updateAddress(User user);

    User getAddress(User user);

    User getUser(User user);

    List getUserList(String role);

    int deleteUser(int userId);

    int addUser(User user);

    int updateTEL(User user);
}
