package com.lanxiang.dao;


import com.lanxiang.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderDao {

    int addOrder(Order order);

    List getOrder(Order order);

    List getOrderNotIs(Order order);


    Order getOrderByOid(String oid);

    List<Map> getOrderByOid2(String oid);

    List getOrderByStat(String stat);

    List getOrderByStat2(String stat);

    int updateOrder(Order order);

    int updateJindu(Order order);

    int shouhuo(Order order);

    int wuliu(Order order);

    int quxiao(String oid);

    int getCountForToday();

    List getOrderForToday();
}
