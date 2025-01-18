package com.qvtu.pojo;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class User {
    
    private Long id;
    
    private String username;
    
    private String password;
    
    private String nickName;
    
    private String email;
    
    private String note;
    
    private String icon;
    
    private Integer status;
    
    private Date createTime;
    
    private Date loginTime;
    
    private List<Role> roles;
} 