package com.yangyang.cloud.controller;


import com.yangyang.cloud.entities.User;
import com.yangyang.cloud.response.ResultData;
import com.yangyang.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.imageio.spi.IIOServiceProvider;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResultData register(@RequestBody User user) {


        // 密码用 PasswordEncoder 加密存储
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);

        System.out.println(user);
        return ResultData.success("注册成功");

    }
}