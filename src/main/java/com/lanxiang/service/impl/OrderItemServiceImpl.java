package com.lanxiang.service.impl;

import com.lanxiang.dao.OrderItemDao;
import com.lanxiang.model.Orderitem;
import com.lanxiang.service.OrderItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Resource
    private OrderItemDao oid;


    @Override
    public int addOrderItem(Orderitem orderitem) {
        return oid.addOrderItem(orderitem);
    }
}
