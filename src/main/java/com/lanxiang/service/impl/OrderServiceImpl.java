package com.lanxiang.service.impl;

import com.lanxiang.dao.OrderDao;
import com.lanxiang.model.Order;
import com.lanxiang.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    public int updateOrder(Order order) {
        return od.updateOrder(order);
    }

    @Override
    public int updateJindu(Order order) {
        return od.updateJindu(order);
    }

    @Override
    public int shouhuo(Order order) {
        return od.shouhuo(order);
    }

    @Override
    public int wuliu(Order order) {
        return od.wuliu(order);
    }

    @Override
    public int quxiao(String oid) {
        return od.quxiao(oid);
    }

    @Override
    public int getCountForToday() {
        return od.getCountForToday();
    }

    @Override
    public List getOrderForToday() {
        return od.getOrderForToday();
    }

    @Override
    public List<Map> getOrderByOid2(String oid) {
        return od.getOrderByOid2(oid);
    }
}
