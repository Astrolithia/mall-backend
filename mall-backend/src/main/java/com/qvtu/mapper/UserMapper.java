package com.qvtu.mapper;

import com.qvtu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    // 根据用户名查询用户
    @Select("select * from ums_admin where username=#{username}")
    User findByUserName(String username);

    // 添加
    @Insert("insert into ums_admin (username, password, create_time, login_time)" +
            " values(#{username}, #{password}, now(), now())")
    void add(String username, String password);

    // 更新
    @Update("update ums_admin set username=#{username}, nick_name = #{nickname}, " +
            "email=#{email} where id=#{id}")
    void update(User user);

    // 更新头像
    @Update("update ums_admin set icon=#{avatarUrl} where id = #{id}")
    void updateAvatar(String avatarUrl, Integer id);

    // 更新密码
    @Update("update ums_admin set password=#{password} where id=#{id}")
    void updatePwd(String password, Integer id);
}
