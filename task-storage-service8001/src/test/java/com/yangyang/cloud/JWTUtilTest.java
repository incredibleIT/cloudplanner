package com.yangyang.cloud;


import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.bouncycastle.util.Bytes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class JWTUtilTest {

    @Test
    public void jwt() {
        Long userid = 1L;

        String key = "yangyang";

        Map<String, Object> map = new HashMap<>();
        map.put("userid", userid);
        System.out.println(JWTUtil.createToken(map, "yangyang".getBytes()));

        JWTPayload payload = JWTUtil.parseToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyaWQiOiIxIn0.f1Hu4hVXlTWlD8takJC9__axUKl_t2bR7432287VbDA").getPayload();
        System.out.println(payload);

        JSONObject jsonObject = JSON.parseObject(payload.toString());
        System.out.println(jsonObject.get("userid"));
    }
}
