package com.lanxiang.service;


import com.lanxiang.model.News;
import com.lanxiang.model.Product;

import java.util.List;

public interface ProductService {

    public List getProductList();

    public  int addProduct(Product product);

    List getNewProduct();

    Product getProductById(int id);
}
