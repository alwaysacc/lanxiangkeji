package com.lanxiang.dao;


import com.lanxiang.model.Orderitem;

import java.util.List;

public interface OrderItemDao {

    int addOrderItem(Orderitem orderitem);

    List getOrderItem(String oid);
}
