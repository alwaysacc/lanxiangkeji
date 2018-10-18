package com.lanxiang.dao;


import com.lanxiang.model.Color;

import java.util.List;

public interface ColorDao {

    List getColorList();

    int deleteColor(int id);

    int addColor(Color color);
}
