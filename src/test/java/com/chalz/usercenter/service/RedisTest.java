package com.chalz.usercenter.service;
import com.chalz.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void test(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        // 增
        valueOperations.set("chalzString","tomato");
        valueOperations.set("chalzInt", 10);
        valueOperations.set("chalzDouble", 1.0);
        User user = new User();
        user.setId(1);
        user.setUsername("chalz");
        valueOperations.set("chalzUser", user);

        // 查
        Object chalz = valueOperations.get("chalzString");
        Assertions.assertTrue("tomato".equals((String)chalz));
        chalz = valueOperations.get("chalzInt");
        Assertions.assertTrue(10 == (Integer)chalz);
        chalz = valueOperations.get("chalzDouble");
        Assertions.assertTrue(1.0 == (Double)chalz);
        System.out.println(valueOperations.get("chalzUser"));
        redisTemplate.delete("chalzString");

    }
}
