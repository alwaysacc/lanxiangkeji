package com.lanxiang.dao;


import com.lanxiang.model.Menxing;

import java.util.List;

public interface MenxingDao {

    List getMenxingList();

    int deleteMenxing(int id);

    int addMenxing(Menxing menxing);

}
