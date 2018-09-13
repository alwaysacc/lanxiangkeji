package com.lanxiang.controller;


import com.lanxiang.model.Order;
import com.lanxiang.model.Orderitem;
import com.lanxiang.model.User;
import com.lanxiang.service.OrderItemService;
import com.lanxiang.service.OrderService;
import com.lanxiang.utils.GetIdForTime;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService os;
    @Resource
    private OrderItemService ois;
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(OrderController.class);// 日志文件

    @RequestMapping("/addOrder")
    public String addOrder(HttpServletRequest request) throws Exception {

        String userjson= request.getParameter("user");

        JSONObject jsonObject=JSONObject.fromObject(userjson);
        User user=(User)JSONObject.toBean(jsonObject, User.class);
        //添加订单
        Order order=new Order();
        SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        order.setOdate(formate.format(new Date()));
        System.out.println(user.getUserId());
        order.setUserId(user.getUserId());
        order.setAddress(user.getAddress());
        order.setName(user.getUserName());
        order.setTel(user.getTel());
        order.setStat("已付款");
        order.setOid("dd"+GetIdForTime.getOrderIdByTime());
        String totalPrice=request.getParameter("totalPrice");
        order.setPrice(totalPrice);
        os.addOrder(order);

        //添加订单项
        String json=request.getParameter("order");
        //json转java对象
        JSONArray jsonArray=JSONArray.fromObject(json);
        System.out.println(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            Object o=jsonArray.get(i);
            JSONObject jsonObject2= JSONObject.fromObject(o);
            Orderitem orderitem=(Orderitem) JSONObject.toBean(jsonObject2, Orderitem.class);

            orderitem.setOid(order.getOid());
        ois.addOrderItem(orderitem);

        }
       /* Object o=jsonArray.get(0);
        JSONObject jsonObject2= JSONObject.fromObject(o);
        Orderitem orderitem=(Orderitem) JSONObject.toBean(jsonObject2, Orderitem.class);
        System.out.println(orderitem.getChanpin());
        System.out.println(jsonArray.size());*/
        return request.getParameter("order");
    }

    @RequestMapping("getOrder")
    public  @ResponseBody List getOrder(HttpServletRequest request){
        String stat=request.getParameter("stat");
        String userjson= request.getParameter("user");
        JSONObject jsonObject=JSONObject.fromObject(userjson);
        User user=(User)JSONObject.toBean(jsonObject, User.class);
        Order order=new Order();
        order.setUserId(user.getUserId());
        order.setStat(stat);
        List orderList=os.getOrder(order);
        return orderList;
    }
    @RequestMapping("getOrderNotIs")
    public  @ResponseBody List getOrderNotIs(HttpServletRequest request){
        String stat=request.getParameter("stat");
        String userjson= request.getParameter("user");
        JSONObject jsonObject=JSONObject.fromObject(userjson);
        User user=(User)JSONObject.toBean(jsonObject, User.class);
        Order order=new Order();
        order.setUserId(user.getUserId());
        order.setStat(stat);
        List orderList=os.getOrderNotIs(order);
        return orderList;
    }
    @RequestMapping("getOrderItem")
    public  @ResponseBody List getOrderItem(HttpServletRequest request){
        String oid=request.getParameter("oid");
        List orderList=ois.getOrderItem(oid);
        return orderList;
    }

    @RequestMapping("getOrderByOid")
    public  @ResponseBody Order getOrderByOid(HttpServletRequest request){
        String oid=request.getParameter("oid");
        Order order=os.getOrderByOid(oid);
        return order;
    }

    @RequestMapping("getOrderByStat")
    public  @ResponseBody List getOrderByStat(HttpServletRequest request){
        String stat=request.getParameter("stat");
        List orderList=os.getOrderByStat(stat);
        return orderList;
    }

    @RequestMapping("getOrderByStat2")
    public  @ResponseBody List getOrderByStat2(HttpServletRequest request){
        String stat=request.getParameter("stat");
        List orderList=os.getOrderByStat2(stat);
        return orderList;
    }

    @RequestMapping("querenOrder")
    public  @ResponseBody int querenOrder(HttpServletRequest request){
        String oid=request.getParameter("oid");
        String stat=request.getParameter("stat");
        Order order=new Order();
        order.setOid(oid);
        order.setStat(stat);
       int rsu=os.querenOrder(order);
        return rsu;
    }
}
