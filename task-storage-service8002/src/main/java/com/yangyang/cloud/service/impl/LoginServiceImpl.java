package com.yangyang.cloud.service.impl;

import cn.hutool.json.JSONUtil;
import cn.hutool.jwt.JWTUtil;
import com.yangyang.cloud.entities.LoginUser;
import com.yangyang.cloud.entities.User;
import com.yangyang.cloud.response.ResultData;
import com.yangyang.cloud.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public ResultData login(User user) {
        // 调用AuthenticationManager authenticate  触发过滤器链, 取到UserDetailService到数据库查到的LoginUser用户信息
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        // 认证不通过抛异常
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("认证不成功");
        }
        // 认证通过取userid, 生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String id = loginUser.getUser().getId().toString();
        Map<String, Object> map = new HashMap<>();
        map.put("userid", id);
        String jwt = JWTUtil.createToken(map, "yangyang".getBytes());
        Map<String, String> map2 = new HashMap<>();
        map2.put("token", jwt);
        // 用户信息存缓存层

        redisTemplate.opsForValue().set("login: " + id, JSONUtil.toJsonStr(loginUser));
        // 做返回
        return ResultData.success(map2);
    }

    @Override
    public ResultData logout() {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) usernamePasswordAuthenticationToken.getPrincipal();

        redisTemplate.delete("login: " + loginUser.getUser().getId().toString());

        return ResultData.success("删除成功");
    }


}
