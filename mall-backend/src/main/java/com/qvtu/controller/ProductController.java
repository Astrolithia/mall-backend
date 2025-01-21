package com.qvtu.controller;

import com.qvtu.pojo.PageBean;
import com.qvtu.pojo.Product;
import com.qvtu.pojo.Result;
import com.qvtu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Result add(@RequestBody @Validated Product product) {
        productService.add(product);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Product>> list(Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer productCategoryId,
            @RequestParam(required = false) Integer deleteStatus) {
        PageBean<Product> pb = productService.list(pageNum, pageSize, productCategoryId, deleteStatus);
        return Result.success(pb);
    }
}
