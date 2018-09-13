package com.lanxiang.service.impl;

import com.lanxiang.dao.OrderItemDao;
import com.lanxiang.model.Orderitem;
import com.lanxiang.service.OrderItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Resource
    private OrderItemDao od;


    @Override
    public int addOrderItem(Orderitem orderitem) {
        return od.addOrderItem(orderitem);
    }

    @Override
    public List getOrderItem(String oid) {
        return od.getOrderItem(oid);
    }
}
