package com.yangyang.cloud;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@MapperScan("com.yangyang.cloud.mapper")
@EnableDiscoveryClient
@RefreshScope // 启用动态刷新生效
public class Main8002 {

    public static void main(String[] args) {
        SpringApplication.run(Main8002.class, args);
    }
}
