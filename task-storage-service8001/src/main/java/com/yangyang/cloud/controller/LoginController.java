package com.yangyang.cloud.controller;

import com.yangyang.cloud.entities.User;
import com.yangyang.cloud.response.ResultData;
import com.yangyang.cloud.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    public ResultData login(@RequestBody User user) {
        return loginService.login(user);
    }

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }


    @GetMapping("/logout")
    public ResultData logout() {
        
        return loginService.logout();

    }
}
