package com.lanxiang.controller;

import com.lanxiang.model.News;
import com.lanxiang.model.Product;
import com.lanxiang.service.NewsService;
import com.lanxiang.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService ps;
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(AdminController.class);// 日志文件


    @RequestMapping("/product_list")
    public String news_list(Model model){
        List<News> list=ps.getProductList();
        model.addAttribute("list",list);
        System.out.println(list.size());
        return "products_list";
    }
    @RequestMapping("/product-add")
    public String news_add(){
        return "product_add";
    }
    @RequestMapping("/addProduct")
    public String addNews(Product product){
        System.out.println(product.getName());
        SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        product.setAddedTime(formate.format(new Date()));

        if (ps.addProduct(product)!=0)
            return "product_list";
        else return "product_add";
    }
/*
    @RequestMapping("/deleteNews")
    public  @ResponseBody int deleteNews(News news,Model model){
        return ns.deleteNews(news);
    }


    @RequestMapping("/news_Sort")
    public String news_Sort(){
        return "news_Sort";
    }
    */
}
