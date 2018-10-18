package com.lanxiang.controller;


import com.lanxiang.service.ChanPinService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/chanpin")
public class ChanPinController {
    @Resource
    private ChanPinService cs;
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(ChanPinController.class);// 日志文件

    @RequestMapping("/getChanPin")
    public @ResponseBody
    List geetChanPin() throws Exception {
            return cs.getChanPin();
    }

}
