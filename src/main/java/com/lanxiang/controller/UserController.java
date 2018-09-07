package com.lanxiang.controller;


import com.lanxiang.model.User;
import com.lanxiang.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService us;
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(UserController.class);// 日志文件

    @RequestMapping("/login")
    public  @ResponseBody User login(HttpServletRequest request) throws Exception {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        User user=new User();
        user.setUserName(userName);
        user.setPassWord(passWord);
        System.out.println(userName);
        User resultUser = us.loginUser(user);
        return resultUser;
    }
    @RequestMapping("/updateAddress")
    public  @ResponseBody int updateAddress(HttpServletRequest request) throws Exception {
        String address = request.getParameter("address");
        int userid = Integer.parseInt(request.getParameter("id"));
        User user=new User();
        user.setAddress(address);
        user.setUserId(userid);
        System.out.println(address);
        int resultUser = us.updateAddress(user);
        System.out.println(resultUser);
        return resultUser;
    }
    @RequestMapping(value = "/getAddress",produces = {"application/json;charset=UTF-8"})
    public @ResponseBody String getAddress(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        int userid = Integer.parseInt(request.getParameter("id"));
        User user=new User();
        user.setUserId(userid);
        User result=us.getAddress(user);
        if (result.getAddress()=="")
            return null;
        return result.getAddress();
    }
}
