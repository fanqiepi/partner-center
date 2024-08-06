package com.chalz.usercenter.service;

import com.chalz.usercenter.mapper.UserMapper;
import com.chalz.usercenter.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

@SpringBootTest
public class InsertUsersTest {
    @Resource
    private UserMapper userMapper;

    /**
     *  批量插入用户
     */
    @Test
    public void doInsertUsers(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 100;
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("fake_Username");
            user.setAvatarUrl("https://img-s-msn-com.akamaized.net/tenant/amp/entityid/BB1msyOf.img");
            user.setGender(0);
            user.setUserAccount("fake_user");
            user.setUserPassword("12345678");
            user.setPhone("123");
            user.setEmail("123@qq.com");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("123123");
            user.setTags("[]");
            userMapper.insert(user);
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}
