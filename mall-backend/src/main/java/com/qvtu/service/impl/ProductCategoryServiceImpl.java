package com.qvtu.service.impl;

import com.qvtu.mapper.ProductCategoryMapper;
import com.qvtu.pojo.ProductCategory;
import com.qvtu.service.ProductCategoryService;
import com.qvtu.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private ProductCategoryMapper productCategoryMapper;

    @Override
    public void add(ProductCategory productCategory) {
        // 补充属性值
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        productCategoryMapper.add(productCategory);
    }
}
