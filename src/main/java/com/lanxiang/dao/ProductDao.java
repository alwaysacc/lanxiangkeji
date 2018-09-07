package com.lanxiang.dao;


import com.lanxiang.model.Product;

import java.util.List;

public interface ProductDao {
    List getProductList();
    int addProduct(Product product);
    List getNewProduct();
    Product getProductById(int id);
}
