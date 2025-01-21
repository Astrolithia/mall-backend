package com.qvtu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class User {

    @NonNull
    private Long id;

    private String username;
    @JsonIgnore // 让springmvc把当前对象转换为json字符串时忽视这个值
    private String password;

    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;

    @NotEmpty
    @Email
    private String email;
    
    private String note;
    
    private String icon;
    
    private Integer status;
    
    private LocalDateTime createTime;
    
    private LocalDateTime loginTime;
    
    private List<Role> roles;
} 