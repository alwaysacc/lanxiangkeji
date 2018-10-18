package com.lanxiang.service.impl;

import com.lanxiang.dao.ColorDao;
import com.lanxiang.model.Color;
import com.lanxiang.service.ColorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {
    @Resource
    private ColorDao cd;

    @Override
    public List getColorList() {
        return cd.getColorList();
    }

    @Override
    public int deleteColor(int id) {
        return cd.deleteColor(id);
    }

    @Override
    public int addColor(Color color) {
        return cd.addColor(color);
    }
}
