package com.qvtu.controller;

import com.qvtu.pojo.ProductCategory;
import com.qvtu.pojo.Result;
import com.qvtu.service.ProductCategoryService;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class ProductCategoryController {

    private ProductCategoryService productCategoryService;

    @PatchMapping
    public Result add(@RequestBody ProductCategory productCategory) {
        productCategoryService.add(productCategory);
        return Result.success();
    }
}
