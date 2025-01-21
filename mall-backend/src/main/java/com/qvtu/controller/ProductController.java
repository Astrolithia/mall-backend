package com.qvtu.controller;


import com.qvtu.pojo.Product;
import com.qvtu.pojo.Result;
import com.qvtu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Result add(@RequestBody Product product) {
        productService.add(product);
        return Result.success();
    }
}
