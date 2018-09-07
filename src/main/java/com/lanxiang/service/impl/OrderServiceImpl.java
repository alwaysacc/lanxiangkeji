package com.lanxiang.service.impl;

import com.lanxiang.dao.OrderDao;
import com.lanxiang.model.Order;
import com.lanxiang.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao od;

    @Override
    public int addOrder(Order order) {
        return od.addOrder(order);
    }
}
