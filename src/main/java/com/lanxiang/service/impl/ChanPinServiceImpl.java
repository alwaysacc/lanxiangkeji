package com.lanxiang.service.impl;

import com.lanxiang.dao.ChanPinDao;
import com.lanxiang.model.Chanpin;
import com.lanxiang.service.ChanPinService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChanPinServiceImpl implements ChanPinService {
    @Resource
    private ChanPinDao cd;

    @Override
    public List getChanPin() {
        return cd.getChanPin();
    }
}
