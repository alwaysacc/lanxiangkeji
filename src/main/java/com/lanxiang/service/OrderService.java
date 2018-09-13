package com.lanxiang.service;


import com.lanxiang.model.Order;

import java.util.List;

public interface OrderService {

    int addOrder(Order order);

    List getOrder(Order order);

    List getOrderNotIs(Order order);

    Order getOrderByOid(String oid);

    List getOrderByStat(String stat);

    List getOrderByStat2(String stat);

    int querenOrder(Order order);
}
