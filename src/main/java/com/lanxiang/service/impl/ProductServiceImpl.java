package com.lanxiang.service.impl;

import com.lanxiang.dao.NewsDao;
import com.lanxiang.dao.ProductDao;
import com.lanxiang.model.News;
import com.lanxiang.model.Product;
import com.lanxiang.service.NewsService;
import com.lanxiang.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao pd;

    @Override
    public List getProductList() {

        return pd.getProductList();
    }
    @Override
    public int addProduct(Product product) {
        return pd.addProduct(product);
    }
}