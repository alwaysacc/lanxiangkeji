package com.lanxiang.service;


import com.lanxiang.model.User;

public interface UserService {

    User loginUser(User user);

    int updateAddress(User user);

    User getAddress(User user);

    User getUser(User user);

}
