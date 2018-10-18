package com.lanxiang.controller;


import com.lanxiang.model.Admin;
import com.lanxiang.service.AdminService;
import org.apache.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService as;
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(AdminController.class);// 日志文件

    @RequestMapping("/login")
    public String login(Admin admin, HttpServletRequest request) throws Exception {
        HttpSession session1 = request.getSession();

        if (session1.getAttribute("currentUser")!=null){
            return "index";
        }
        Admin resultAdmin=as.findAdmin(admin);
        request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");
        if (resultAdmin == null) {
            System.out.println(admin.getUsername());
            request.setAttribute("admin", admin);
            request.setAttribute("errorMsg", "请认真核对账号、密码！");
            return "login";
        } else {
            System.out.println(admin.getUsername());
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", resultAdmin);
            MDC.put("userName", admin.getAdminName());
            return "index";
        }
    }
    @RequestMapping("/home")
    public String home() {
        System.out.println(233);
    return  "home";
    }
}
