package com.qvtu.service;

import com.qvtu.pojo.PageBean;
import com.qvtu.pojo.Product;

public interface ProductService {
    // 添加商品
    void add(Product product);

    // 查询商品列表
    PageBean<Product> list(Integer pageNum, Integer pageSize, Integer productCategoryId, Integer deleteStatus);

    // 更新商品
    void update(Product product);

    // 删除商品
    void delete(Integer id);
}
