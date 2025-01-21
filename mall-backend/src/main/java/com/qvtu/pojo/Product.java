package com.qvtu.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.validator.constraints.URL;

@Data
public class Product {
    @NotNull(groups = Update.class)

    private Long id;

    private Long brandId;

    private Long productCategoryId;

    @NotEmpty(message = "商品名称不能为空")
    @Pattern(regexp = "^\\S{1,10}$")
    private String name;

    @URL(message = "图片格式错误")
    private String pic;

    private String productSn;

    private Integer deleteStatus;

    private Integer publishStatus;

    private Integer newStatus;

    private Integer recommandStatus;

    @NotNull(message = "商品价格不能为空")
    @DecimalMin(value = "0.01", message = "商品价格必须大于0")
    private BigDecimal price;

    private String description;

    @Min(value = 0, message = "库存不能小于0")
    private Integer stock;

    private BigDecimal weight;

    private String keywords;

    private String note;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    // 分组校验接口
    public interface Add extends Default {
    }

    public interface Update extends Default {
    }
}
