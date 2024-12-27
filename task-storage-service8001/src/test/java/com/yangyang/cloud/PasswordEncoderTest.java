package com.yangyang.cloud;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordEncoderTest {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Test
    public void encode() {
        System.out.println(passwordEncoder.encode("root"));
        System.out.println(passwordEncoder.matches("123456", passwordEncoder.encode("123456")));
    }
}
