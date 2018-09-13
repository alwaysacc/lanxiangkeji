package com.lanxiang.service.impl;

import com.lanxiang.dao.OrderDao;
import com.lanxiang.model.Order;
import com.lanxiang.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao od;

    @Override
    public int addOrder(Order order) {
        return od.addOrder(order);
    }

    @Override
    public List getOrder(Order order) {
        return od.getOrder(order);
    }

    @Override
    public List getOrderNotIs(Order order) {
        return od.getOrderNotIs(order);
    }

    @Override
    public Order getOrderByOid(String oid) {
        return od.getOrderByOid(oid);
    }

    @Override
    public List getOrderByStat(String stat) {
        return od.getOrderByStat(stat);
    }

    @Override
    public List getOrderByStat2(String stat) {
        return od.getOrderByStat2(stat);
    }

    @Override
    public int querenOrder(Order order) {
        return od.querenOrder(order);
    }
}
