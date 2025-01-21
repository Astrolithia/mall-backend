package com.qvtu.pojo;

import jakarta.validation.groups.Default;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Data
public class ProductCategory {

    @NotNull(groups = Update.class)
    private Long id;

    @NotNull(groups = Add.class)
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

    public interface Add extends Default {

    }

    public interface Update extends Default{

    }
}