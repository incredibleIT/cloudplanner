package com.yangyang.cloud.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TaskOrderController {

    private static final String url = "http://task-storage-service";

    @Resource
    private RestTemplate restTemplate;



}
