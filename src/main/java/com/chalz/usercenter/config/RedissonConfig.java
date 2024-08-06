package com.chalz.usercenter.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.config.Config;
import org.redisson.api.RedissonClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Redisson配置
 *
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedissonConfig {

    private static final Logger logger = LoggerFactory.getLogger(RedissonConfig.class);

    private String host;
    private String port;
    private String password;

    @Bean
    public RedissonClient redissonClient() {
        // 日志输出配置属性
        logger.info("Configuring RedissonClient with host: {}, port: {}, password: {}", host, port, (password != null && !password.isEmpty()) ? "******" : "no password");

        // 1. 创建配置
        Config config = new Config();
        String redisAddress = String.format("redis://%s:%s", host, port);
        config.useSingleServer()
                .setAddress(redisAddress)
                .setDatabase(1);

        // 仅当密码不为空时设置密码
        if (password != null && !password.isEmpty()) {
            config.useSingleServer().setPassword(password);
        }

        // 2. 创建实例
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}
