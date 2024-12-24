package com.yangyang.cloud.entities;


import lombok.Data;

@Data
public class UserDto {
    private String username;    // 用户名
    private String password;    // 密码
    private String email;       // 电子邮件
}
