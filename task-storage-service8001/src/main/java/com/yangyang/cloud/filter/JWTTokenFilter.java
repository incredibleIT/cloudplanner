package com.yangyang.cloud.filter;

import cn.hutool.json.JSONUtil;
import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.yangyang.cloud.entities.LoginUser;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;
import java.util.Objects;


@Component
public class JWTTokenFilter extends OncePerRequestFilter {



    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            filterChain.doFilter(request, response);
            System.out.println("1111111111111111");
            return ;
        }

        // 解析token
        JSONObject jsonObject = JSON.parseObject(JWTUtil.parseToken(token).getPayload().toString());
        String userId = (String) jsonObject.get("userid");
        // 从缓冲层查询id对应的loginUser
        Object o = redisTemplate.opsForValue().get("login: " + userId);
        if (o == null) {
            System.out.println("2222222222222222");
//            throw new RuntimeException("用户未登录");

            sendErrorResponse(response, "未登录");
            return ;
        }

        LoginUser loginUser = JSONUtil.toBean(o.toString(), LoginUser.class);
        System.out.println(loginUser);

        // 存入SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(loginUser, null, null));
        // 放行
        filterChain.doFilter(request, response);
    }

    // 发送 JSON 错误响应的方法
    private void sendErrorResponse(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 设置状态码为 401
        response.setContentType("application/json;charset=UTF-8");

        // 构建 JSON 错误响应
        String jsonResponse = "{ \"status\": 401, \"message\": \"" + message + "\" }";
        response.getWriter().write(jsonResponse);
    }
}
