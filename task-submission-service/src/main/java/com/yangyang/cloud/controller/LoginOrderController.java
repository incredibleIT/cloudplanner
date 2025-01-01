package com.yangyang.cloud.controller;


import com.yangyang.cloud.entities.User;
import com.yangyang.cloud.response.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoginOrderController {

    private static final String url = "http://task-storage-service";

    @Autowired
    private RestTemplate restTemplate;



    @PostMapping("/submit/user/login")
    public ResultData login(@RequestBody User user) {
        return restTemplate.postForObject(url + "/user/login",user, ResultData.class);
    }

    @GetMapping("/submit/user/logout")
    public ResultData logout() {
        return restTemplate.postForObject(url + "/user/logout", null, ResultData.class);
    }



}
