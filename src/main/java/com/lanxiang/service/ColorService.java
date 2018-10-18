package com.lanxiang.service;

import com.lanxiang.model.Color;

import java.util.List;

public interface ColorService {

    List getColorList();

    int deleteColor(int id);

    int addColor(Color color);
}
