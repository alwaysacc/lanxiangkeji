package com.lanxiang.controller;

import com.lanxiang.model.Color;
import com.lanxiang.model.Menxing;
import com.lanxiang.model.User;
import com.lanxiang.service.ColorService;
import com.lanxiang.service.MenxingService;
import com.lanxiang.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService us;
    @Resource
    private ColorService cs;
    @Resource
    private MenxingService ms;
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(UserController.class);// 日志文件

    @RequestMapping("/login")
    public  @ResponseBody User login(HttpServletRequest request) throws Exception {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        User user=new User();
        user.setTel(userName);
        user.setPassWord(passWord);
        System.out.println(userName);
        User resultUser = us.loginUser(user);
        return resultUser;
    }
    @RequestMapping("/updateAddress")
    public  @ResponseBody int updateAddress(HttpServletRequest request) throws Exception {
        String address = request.getParameter("address");
        String userjson= request.getParameter("user");
        JSONObject jsonObject=JSONObject.fromObject(userjson);
        User user=(User)JSONObject.toBean(jsonObject, User.class);
        user.setAddress(address);
        System.out.println(address);
        int resultUser = us.updateAddress(user);
        System.out.println(resultUser);
        return resultUser;
    }
    @RequestMapping(value = "/getAddress",produces = {"application/json;charset=UTF-8"})
    public @ResponseBody String getAddress(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String userjson= request.getParameter("user");
        JSONObject jsonObject=JSONObject.fromObject(userjson);
        User user=(User)JSONObject.toBean(jsonObject, User.class);
        User result=us.getUser(user);
        if (result.getAddress()==null)
            return "";
        return result.getAddress();
    }

    @RequestMapping(value = "/getUserList",produces = {"application/json;charset=UTF-8"})
    public @ResponseBody List getUserList(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String role =request.getParameter("role");
        return  us.getUserList(role);
    }

    @RequestMapping(value = "/deleteUser")
    public @ResponseBody int deleteUser(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        return  us.deleteUser(userId);
    }
    @RequestMapping(value = "/addUser")
    public @ResponseBody int addUser(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        String userjson= request.getParameter("user");
        JSONArray json=JSONArray.fromObject(userjson);
        Object o=json.get(0);
        JSONObject jsonObject2= JSONObject.fromObject(o);
        User user=(User) JSONObject.toBean(jsonObject2, User.class);
        user.setRole("3");
        return  us.addUser(user);
    }

    @RequestMapping("/updateTel")
    public  @ResponseBody int updateTel(HttpServletRequest request) throws Exception {
        String tel = request.getParameter("tel");
        String userjson= request.getParameter("user");
        JSONObject jsonObject=JSONObject.fromObject(userjson);
        User user=(User)JSONObject.toBean(jsonObject, User.class);
        user.setTel(tel);
        int resultUser = us.updateTEL(user);
        return resultUser;
    }
    @RequestMapping("/updateEmail")
    public  @ResponseBody int updateEmail(HttpServletRequest request) throws Exception {
        String email = request.getParameter("email");
        String userjson= request.getParameter("user");
        JSONObject jsonObject=JSONObject.fromObject(userjson);
        User user=(User)JSONObject.toBean(jsonObject, User.class);
        user.setEmail(email);
        int resultUser = us.updateEmail(user);
        return resultUser;
    }
    @RequestMapping("/updateDianpu")
    public  @ResponseBody int updateDianpu(HttpServletRequest request) throws Exception {
        String dianpu = request.getParameter("dianpu");
        String userjson= request.getParameter("user");
        JSONObject jsonObject=JSONObject.fromObject(userjson);
        User user=(User)JSONObject.toBean(jsonObject, User.class);
        user.setDianpu(dianpu);
        int resultUser = us.updateDianPu(user);
        return resultUser;
    }
    @RequestMapping("/getUser")
    public  @ResponseBody User getUser(HttpServletRequest request) throws Exception {
        String userjson= request.getParameter("user");
        JSONObject jsonObject=JSONObject.fromObject(userjson);
        User user=(User)JSONObject.toBean(jsonObject, User.class);
        User resultUser = us.getUser(user);
        return resultUser;
    }
    @RequestMapping("/getColor")
    public  @ResponseBody List getColor(HttpServletRequest request) throws Exception {
        return cs.getColorList();
    }
    @RequestMapping("/deleteColor")
    public  @ResponseBody int deleteColor(HttpServletRequest request) throws Exception {
        int id= Integer.parseInt(request.getParameter("id"));
        return cs.deleteColor(id);
    }
    @RequestMapping(value = "/addColor")
    public @ResponseBody int addColor(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String userjson= request.getParameter("color");
        JSONArray json=JSONArray.fromObject(userjson);
        Object o=json.get(0);
        JSONObject jsonObject2= JSONObject.fromObject(o);
        Color color =(Color) JSONObject.toBean(jsonObject2, Color.class);
        return  cs.addColor(color);
    }


    @RequestMapping("/getMenxing")
    public  @ResponseBody List getMenxing(HttpServletRequest request) throws Exception {
        return ms.getMenxingList();
    }
    @RequestMapping("/deleteMenxing")
    public  @ResponseBody int deleteMenxing(HttpServletRequest request) throws Exception {
        int id= Integer.parseInt(request.getParameter("id"));
        return ms.deleteMenxing(id);
    }

    @RequestMapping(value = "/addMenxing")
    public @ResponseBody int addMenxing(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String userjson= request.getParameter("menxing");
        JSONArray json=JSONArray.fromObject(userjson);
        Object o=json.get(0);
        JSONObject jsonObject2= JSONObject.fromObject(o);
        Menxing menxing =(Menxing) JSONObject.toBean(jsonObject2, Menxing.class);
        return  ms.addMenxing(menxing);
    }

    @RequestMapping(value = "/downloadApp")
    public String downloadApp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "app";
    }
}