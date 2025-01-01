package com.yangyang.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangyang.cloud.entities.User;
import com.yangyang.cloud.mapper.UserMapper;
import com.yangyang.cloud.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}