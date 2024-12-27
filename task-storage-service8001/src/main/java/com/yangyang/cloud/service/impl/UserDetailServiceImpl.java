package com.yangyang.cloud.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yangyang.cloud.entities.LoginUser;
import com.yangyang.cloud.entities.User;
import com.yangyang.cloud.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> wrapper= new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);

        User user = userMapper.selectOne(wrapper);

        return new LoginUser(user);
    }
}
