package com.chalz.usercenter.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chalz.usercenter.mapper.UserMapper;
import com.chalz.usercenter.model.domain.User;
import com.chalz.usercenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 缓存预热任务
 *
 * @author chalz
 */
@Component
@Slf4j
public class PreCacheJob {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedissonClient redissonClient;

    // 设置常用的（比如某个重点用户）
    private List<Long> mainUser = Arrays.asList(3L);

    // 每天23点59分执行预热
    @Scheduled(cron = "0 59 23 * * ? ")
    public void doCacheRecommendUser() {
        // todo 这里可以把"fanqiepi:user:recommend:%s"提取成全局变量了，controller里也用到了
        RLock lock = redissonClient.getLock("fanqiepi:precachejob:docache:lock");
        try {
            // 只有一个线程能够获取锁(等待时间，过期时间)
            if(lock.tryLock(0,10000L,TimeUnit.MILLISECONDS)){
                System.out.println("getLock" + Thread.currentThread().getId());
                for (Long userId : mainUser) {
                    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                    Page<User> userPage = userService.page(new Page<>(1, 20), queryWrapper);
                    String redisKey = String.format("fanqiepi:user:recommend:%s", userId);
                    ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
                    // 写缓存
                    try {
                        valueOperations.set(redisKey, userPage, 10000, TimeUnit.MICROSECONDS);
                    } catch (Exception e) {
                        log.error("redis set key error", e);
                    }
                }
            }
        } catch (InterruptedException e) {
           log.error("doCacheRecommendUser error", e);
           // 防止报错不执行释放锁
        } finally {
            System.out.println("unLock" + Thread.currentThread().getId());
            // 只能释放自己的锁
            if(lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }
}
