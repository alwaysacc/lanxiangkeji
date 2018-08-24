package com.lanxiang.service.impl;

import com.lanxiang.dao.AdminDao;
import com.lanxiang.model.Admin;
import com.lanxiang.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl  implements AdminService {
    @Resource
    private AdminDao ad;

    @Override
    public Admin findAdmin(Admin admin) {
        return ad.findAdmin(admin);

    }
}
