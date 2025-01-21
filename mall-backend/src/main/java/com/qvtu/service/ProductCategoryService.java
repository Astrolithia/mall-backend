package com.qvtu.service;

import com.qvtu.pojo.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    // 新增分类
    void add(ProductCategory productCategory);

    // 列表查询
    List<ProductCategory> list();

    // 根据id查询分类
    ProductCategory findById(Integer id);

    // 修改分类
    void update(ProductCategory productCategory);
}
