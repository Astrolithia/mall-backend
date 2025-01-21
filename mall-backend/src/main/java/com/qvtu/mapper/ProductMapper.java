package com.qvtu.mapper;

import com.qvtu.pojo.Product;
import org.apache.ibatis.annotations.*;

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

    @Update("UPDATE pms_product SET name = #{name}, pic = #{pic}, product_sn = #{productSn}, " +
            "delete_status = #{deleteStatus}, publish_status = #{publishStatus}, " +
            "new_status = #{newStatus}, recommand_status = #{recommandStatus}, " +
            "price = #{price}, description = #{description}, stock = #{stock}, " +
            "weight = #{weight}, keywords = #{keywords} WHERE id = #{id}")
    void update(Product product);

    @Delete("DELETE FROM pms_product WHERE id = #{id}")
    void delete(Integer id);
}
