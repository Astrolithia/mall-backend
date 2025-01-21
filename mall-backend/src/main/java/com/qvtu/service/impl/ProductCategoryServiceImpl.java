package com.qvtu.service.impl;

import com.qvtu.mapper.ProductCategoryMapper;
import com.qvtu.pojo.ProductCategory;
import com.qvtu.service.ProductCategoryService;
import com.qvtu.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public void add(ProductCategory category) {
        productCategoryMapper.add(category);
    }

    @Override
    public List<ProductCategory> list() {
        return productCategoryMapper.list();
    }

    @Override
    public ProductCategory findById(Integer id) {
        return productCategoryMapper.findById(id);
    }

    @Override
    public void update(ProductCategory productCategory) {
        productCategoryMapper.update(productCategory);
    }

}