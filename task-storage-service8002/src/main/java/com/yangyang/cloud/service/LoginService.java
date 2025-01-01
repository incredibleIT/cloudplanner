package com.yangyang.cloud.service;

import com.yangyang.cloud.entities.User;
import com.yangyang.cloud.response.ResultData;

public interface LoginService {
    ResultData login(User user);

    ResultData logout();

}
