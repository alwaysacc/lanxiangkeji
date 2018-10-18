package com.lanxiang.service;


import com.lanxiang.model.Orderitem;

import java.util.List;
import java.util.Map;

public interface OrderItemService {
    int addOrderItem(Orderitem orderitem);

    List<Map> getOrderItem(String oid);

    int quxiaoOrder(String oid);
}
