package com.yangyang.cloud.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Err {

    @RequestMapping("/err")
    public void err(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("2222222222222222222222222222222");
        throw new RuntimeException(req.getAttribute("msg").toString());
    }
}
