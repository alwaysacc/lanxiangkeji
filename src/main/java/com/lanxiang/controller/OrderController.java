package com.lanxiang.controller;


import com.lanxiang.model.Order;
import com.lanxiang.model.Orderitem;
import com.lanxiang.service.OrderItemService;
import com.lanxiang.service.OrderService;
import com.lanxiang.utils.GetIdForTime;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService os;
    private OrderItemService ois;
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(OrderController.class);// 日志文件

    @RequestMapping("/addOrder")
    public String addOrder(HttpServletRequest request) throws Exception {
        String json=request.getParameter("order");
        int userid= Integer.parseInt(request.getParameter("userid"));
        //添加订单
        Order order=new Order();
        SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        order.setOdate(formate.format(new Date()));
        order.setUserId(userid);
        order.setStat("未付款");
        os.addOrder(order);
        //添加订单项
        System.out.println( GetIdForTime.getOrderIdByTime());

        //json转java对象
        JSONArray jsonArray=JSONArray.fromObject(json);
    for (int i = 0; i < jsonArray.size()-1; i++) {
            Object o=jsonArray.get(i);
            JSONObject jsonObject2= JSONObject.fromObject(o);
            Orderitem orderitem=(Orderitem) JSONObject.toBean(jsonObject2, Orderitem.class);
            String a=GetIdForTime.getOrderIdByTime();
            orderitem.setItemid(1);
            ois.addOrderItem(orderitem);
            System.out.println(orderitem.getChanpin());
        }
       /* Object o=jsonArray.get(0);
        JSONObject jsonObject2= JSONObject.fromObject(o);
        Orderitem orderitem=(Orderitem) JSONObject.toBean(jsonObject2, Orderitem.class);
        System.out.println(orderitem.getChanpin());
        System.out.println(jsonArray.size());*/
        return request.getParameter("order");
    }
}
