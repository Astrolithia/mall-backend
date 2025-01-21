package com.qvtu.mapper;

import com.qvtu.pojo.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("INSERT INTO pms_product(product_category_id, name, pic, product_sn, " +
            "delete_status, publish_status, new_status, recommand_status, price, " +
            "description, stock, weight, keywords) VALUES (#{productCategoryId}, " +
            "#{name}, #{pic}, #{productSn}, #{deleteStatus}, #{publishStatus}, " +
            "#{newStatus}, #{recommandStatus}, #{price}, #{description}, #{stock}, " +
            "#{weight}, #{keywords})")
    void add(Product product);

    List<Product> list(Integer userId, Integer productCategoryId, Integer deleteStatus);
}
