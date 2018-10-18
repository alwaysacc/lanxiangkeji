package com.lanxiang.service;


import com.lanxiang.model.Menxing;

import java.util.List;

public interface MenxingService {

    List getMenxingList();

    int deleteMenxing(int id);

    int addMenxing(Menxing menxing);
}
