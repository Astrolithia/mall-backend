package com.qvtu.mapper;

import com.qvtu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    // 根据用户名查询用户
    @Select("select * from ums_admin where username=#{username}")
    User findByUserName(String username);

    // 添加
    @Insert("insert into ums_admin (username, password, create_time)" +
            " values(#{username}, #{password}, now())")
    void add(String username, String password);
}
