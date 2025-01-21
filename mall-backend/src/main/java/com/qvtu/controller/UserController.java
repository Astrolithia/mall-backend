package com.qvtu.controller;

import ch.qos.logback.core.util.MD5Util;
import com.auth0.jwt.JWT;
import com.qvtu.pojo.Result;
import com.qvtu.pojo.User;
import com.qvtu.service.UserService;
import com.qvtu.utils.JwtUtil;
import com.qvtu.utils.Md5Util;
import com.qvtu.utils.ThreadLocalUtil;

import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{2,16}$") String username,
                           @Pattern(regexp = "^\\S{8,16}$") String password) {
        // 查询用户
        User u = userService.findByUserName(username);
        if (u == null) {
            // 用户名没有被占用
            // 注册
            userService.register(username, password);
            return Result.success();
        } else {
            // 用户名被占用
            return Result.error("用户名已被占用");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{2,16}$") String username,
                                @Pattern(regexp = "^\\S{8,16}$") String password) {
        // 根据用户名查询用户
        User loginUser = userService.findByUserName(username);
        // 判断该用户是否存在
        if (loginUser == null) {
            return Result.error("用户名错误");
        }

        // 判断密码是否正确 loginUser对象中的password是密文
        if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
            // 登录成功
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }

        return Result.error("密码错误");
    }

    @GetMapping("/userInfo")
    public Result<User> getUserInfo() {
        Map<String, Object> map = ThreadLocalUtil.get();
        if (map == null) {
            return Result.error("用户未登录");
        }
        
        String username = (String) map.get("username");
        if (username == null) {
            return Result.error("用户信息获取失败");
        }
        
        User user = userService.findByUserName(username);
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl) {
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String, String> params) {
        // 1. 校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        if (oldPwd == null || newPwd == null || rePwd == null) {
            return Result.error("缺少必要的参数");
        }

        // 原密码是否正确
        // 调用userService根据用户名拿到原密码，再和old_pwd比对
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userService.findByUserName(username);
        if (loginUser == null) {
            return Result.error("用户不存在");
        }
        if (!Md5Util.getMD5String(oldPwd).equals(loginUser.getPassword())) {
            return Result.error("原密码错误");
        }

        // 2. 判断新密码和确认密码是否一致
        if (!newPwd.equals(rePwd)) {
            return Result.error("新密码和确认密码不一致");
        }

        // 3. 更新密码
        userService.updatePwd(newPwd);
        return Result.success();
    }
}

