package com.qvtu.mapper;

import com.qvtu.pojo.ProductCategory;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProductCategoryMapper {
    // 新增
    @Insert("insert into pms_product_category(parent_id, name, level , keywords, description) " +
            "values(#{parentId}, #{name}, #{level}, #{keywords}, #{description})")
    void add(ProductCategory productCategory);

    // 查询
    @Select("select * from pms_product_category")
    List<ProductCategory> list();

    // 根据id查询
    @Select("select * from pms_product_category where id = #{id}")
    ProductCategory findById(Integer id);

    // 修改
    @Update("update pms_product_category set name = #{name}, keywords = #{keywords}, description = #{description} where id = #{id}")
    void update(ProductCategory productCategory);
}
