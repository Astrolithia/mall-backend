package com.qvtu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qvtu.mapper.ProductMapper;
import com.qvtu.pojo.PageBean;
import com.qvtu.pojo.Product;
import com.qvtu.service.ProductService;
import com.qvtu.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void add(Product product) {
        // 补充属性值
        product.setCreateTime(LocalDateTime.now());
        product.setUpdateTime(LocalDateTime.now());
        productMapper.add(product);
    }

    @Override
    public PageBean<Product> list(Integer pageNum, Integer pageSize, Integer productCategoryId, Integer deleteStatus) {
        // 1. 创建PageBean对象
        PageBean<Product> pb = new PageBean<>();

        // 2. 开启分页查询
        PageHelper.startPage(pageNum, pageSize);

        // 3. 调用Mapper
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        List<Product> ps = productMapper.list(userId, productCategoryId, deleteStatus);
        // page中提供了方法，可以获取PageHelper分页查询后 得到的总记录条数和当前页数据
        Page<Product> p = (Page<Product>) ps;
        // 把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public void update(Product product) {
        // 补充属性值
        product.setUpdateTime(LocalDateTime.now());
        productMapper.update(product);
    }

    @Override
    public void delete(Integer id) {
        productMapper.delete(id);
    }
}
