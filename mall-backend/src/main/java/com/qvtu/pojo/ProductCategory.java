package com.qvtu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class ProductCategory {
    private Long id;
    
    private Long parentId;
    
    @NotEmpty(message = "分类名称不能为空")
    private String name;
    
    private Integer level;
    
    private Integer showStatus;
    
    private Integer sort;
    
    private String icon;
    
    private String keywords;
    
    private String description;
    
    // 子分类列表
    private List<ProductCategory> children;
} 