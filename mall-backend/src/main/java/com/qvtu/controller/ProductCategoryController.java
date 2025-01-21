package com.qvtu.controller;

import com.qvtu.pojo.ProductCategory;
import com.qvtu.pojo.Result;
import com.qvtu.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productcategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping
    public Result add(@RequestBody @Validated(ProductCategory.Add.class) ProductCategory productCategory) {
        productCategoryService.add(productCategory);
        return Result.success();
    }

    @GetMapping
    public Result<List<ProductCategory>> list() {
        List<ProductCategory> pc = productCategoryService.list();
        return Result.success(pc);
    }

    @GetMapping("/detail")
    public Result<ProductCategory> detail(@RequestParam Integer id) {
        ProductCategory pc = productCategoryService.findById(id);
        return Result.success(pc);
    }

    @PutMapping
    public Result update(@RequestBody @Validated(ProductCategory.Update.class) ProductCategory productCategory) {
        productCategoryService.update(productCategory);
        return Result.success();
    }
}
