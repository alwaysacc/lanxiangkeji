package com.lanxiang.service.impl;

import com.lanxiang.dao.UserDao;
import com.lanxiang.model.User;
import com.lanxiang.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao ud;


    @Override
    public User loginUser(User user) {
        return ud.loginUser(user);
    }

    @Override
    public int updateAddress(User user) {
        return ud.updateAddress(user);
    }

    @Override
    public User getAddress(User user) {
        return ud.getAddress(user);
    }

    @Override
    public User getUser(User user) {
        return ud.getUser(user);
    }

    @Override
    public List getUserList(String role) {
        return ud.getUserList(role);
    }

    @Override
    public int deleteUser(int userId) {
        return ud.deleteUser(userId);
    }

    @Override
    public int addUser(User user) {
        return ud.addUser(user);
    }

    @Override
    public int updateTEL(User user) {
        return ud.updateTEL(user);
    }

}