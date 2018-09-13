package com.lanxiang.service;


import com.lanxiang.model.Orderitem;

import java.util.List;

public interface OrderItemService {
    int addOrderItem(Orderitem orderitem);

    List getOrderItem(String oid);
}
