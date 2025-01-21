package com.qvtu.mapper;

import com.qvtu.pojo.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductCategoryMapper {
    void add(ProductCategory productCategory);
}
