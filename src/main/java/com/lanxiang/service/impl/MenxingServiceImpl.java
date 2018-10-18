package com.lanxiang.service.impl;

import com.lanxiang.dao.MenxingDao;
import com.lanxiang.model.Menxing;
import com.lanxiang.service.MenxingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenxingServiceImpl implements MenxingService {
    @Resource
    private MenxingDao md;


    @Override
    public List getMenxingList() {
        return md.getMenxingList();
    }

    @Override
    public int deleteMenxing(int id) {
        return md.deleteMenxing(id);
    }

    @Override
    public int addMenxing(Menxing menxing) {
        return md.addMenxing(menxing);
    }

}
