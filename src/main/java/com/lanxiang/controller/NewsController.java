package com.lanxiang.controller;

import com.github.pagehelper.Page;
import com.lanxiang.model.News;
import com.lanxiang.service.NewsService;
import com.lanxiang.utils.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Resource
    private NewsService ns;
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(AdminController.class);// 日志文件


    @RequestMapping("/news_list")
    public String news_list(PageInfo PageInfo, Model model){
        PageInfo.setStartRow(1);
        PageInfo.setSize(5);
        List<News> list=ns.getNewsList(PageInfo);
        System.out.println(list.get(1));
        model.addAttribute("list",list);
        return "news_list";
    }

    @RequestMapping("/news_Sort")
    public String news_Sort(){
        return "news_Sort";
    }
    @RequestMapping("/news_add")
    public String news_add(){
        return "news_add";
    }
}
