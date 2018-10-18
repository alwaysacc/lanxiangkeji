package com.lanxiang.controller;


import com.lanxiang.model.Order;
import com.lanxiang.model.Orderitem;
import com.lanxiang.model.User;
import com.lanxiang.service.OrderItemService;
import com.lanxiang.service.OrderService;
import com.lanxiang.utils.ExportExcelUtil;
import com.lanxiang.utils.GetIdForTime;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private JavaMailSender javaMailSender;
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
        SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setOdate(formate.format(new Date()));
        System.out.println(user.getUserId());
        order.setUserId(user.getUserId());
        order.setAddress(user.getAddress());
        order.setName(user.getUserName());
        order.setTel(user.getTel());
        order.setStat("已付款");
        order.setOid("LX"+GetIdForTime.getOrderIdByTime());
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
            System.out.println(orderitem.getLvwang());
            orderitem.setOid(order.getOid());
            ois.addOrderItem(orderitem);
            System.out.println(orderitem.getMenxing());
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
        List orderList=os.getOrderByStat2(stat);
        return orderList;
    }

    @RequestMapping("getOrderByStat2")
    public  @ResponseBody List getOrderByStat2(HttpServletRequest request){
        String stat=request.getParameter("stat");
        List orderList=os.getOrderByStat(stat);
        return orderList;
    }

    @RequestMapping("updateOrder")
    public  @ResponseBody int updateOrder(HttpServletRequest request){
        String oid=request.getParameter("oid");
        String stat=request.getParameter("stat");
        String jindu=request.getParameter("jd");
        Order order=new Order();
        order.setOid(oid);
        order.setStat(stat);
        order.setJindu(jindu);
        System.out.println(jindu);
        int a=os.updateJindu(order);
       int rsu=os.updateOrder(order);
        return rsu;
    }
    @RequestMapping("updateJindu")
    public  @ResponseBody int updateJindu(HttpServletRequest request){
        String oid=request.getParameter("oid");
        String jindu=request.getParameter("jindu");
        Order order=new Order();
        order.setOid(oid);
       order.setJindu(jindu);
        int rsu=os.updateJindu(   order);
        return rsu;
    }
    @RequestMapping("shouhuo")
    public  @ResponseBody int shouhuo(HttpServletRequest request){
        String oid=request.getParameter("oid");
        Order order=new Order();
        order.setOid(oid);
        order.setStat("已完成");
        int rsu=os.shouhuo(order);
        return rsu;
    }
    @RequestMapping("wuliu")
    public  @ResponseBody int wuliu(HttpServletRequest request){
        String oid=request.getParameter("oid");
        String wuliu=request.getParameter("wuliu");
        Order order=new Order();
        order.setOid(oid);
        order.setWuliu(wuliu);
        int rsu=os.wuliu(order);
        return rsu;
    }
    @RequestMapping("quxiaoOrder")
    public  @ResponseBody int quxiaoOrder(HttpServletRequest request){
        String oid=request.getParameter("oid");
        ois.quxiaoOrder(oid);
        int rsu=os.quxiao(oid);
        return rsu;
    }
    @RequestMapping("getCountForToday")
    public  @ResponseBody int getCountForToday(HttpServletRequest request){
        int a=os.getCountForToday();
        return a;
    }
    @RequestMapping("getOrderForToday")
    public  @ResponseBody List getOrderForToday(HttpServletRequest request){
        List list=os.getOrderForToday();
        return list;
    }

    @RequestMapping("sendEmail")
    public @ResponseBody int send(HttpServletRequest request){
        String email=request.getParameter("email");
        String path=request.getServletContext().getRealPath("/");
        System.out.println(path);
        ExportExcelUtil eeu=new ExportExcelUtil();
        String[] title1 = "ID,产品,门型,颜色,尺寸,门向,门锁,合页,门吸,数量,备注".split(",");
        String[] column1 = "itemid,chanpin,menxing,color,chicun,menxiang,mensuo,heye,menxi,num,beizhu".split(",");
        String oid=request.getParameter("oid");
        List<Map> orderList=ois.getOrderItem(oid);
        System.out.println(orderList.size());
        String fileName = oid;
        eeu.getOutputFile(title1, column1, orderList, fileName,path);
        List<Map> order=os.getOrderByOid2(oid);
        String filename="收货人信息"+oid;
        String[] title2= "订单编号,收货人,电话,地址".split(",");
        String[] column2= "oid,name,tel,address".split(",");
        eeu.getOutputFile(title2, column2, order, filename,path);
        MimeMessage mMessage=javaMailSender.createMimeMessage();//创建邮件对象
        MimeMessageHelper mMessageHelper;
        Properties prop = new Properties();
        String from;
        try{
            //从配置文件中拿到发件人邮箱地址
            prop.load(this.getClass().getResourceAsStream("/mail.properties"));
            from = prop.get("mail.smtp.username")+"";
            mMessageHelper=new MimeMessageHelper(mMessage,true);
            mMessageHelper.setFrom(from);//发件人邮箱
            mMessageHelper.setCc(from);
            mMessageHelper.setTo(email);//收件人邮箱
            mMessageHelper.setSubject(oid+"订单详情");//邮件的主题
            mMessageHelper.setText("<p>订单编号为" +oid+"的产品详情</p>",true);//邮件的文本内容，true表示文本以html格式打开
            String filepath=path+fileName+".xls";
            File file=new File(filepath);//在邮件中添加一张图片
            System.out.println(filepath);
            File file2=new File(path+filename+".xls");
            FileSystemResource resource=new FileSystemResource(file);
            FileSystemResource resource2=new FileSystemResource(file2);
            mMessageHelper.addAttachment(fileName+".xls", resource);//在邮件中添加一个附件
          mMessageHelper.addAttachment(filename+".xls", resource2);
            javaMailSender.send(mMessage);//发送邮件
            file.delete();
            file2.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

}
