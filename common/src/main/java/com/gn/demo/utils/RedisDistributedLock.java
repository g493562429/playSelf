package com.gn.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Author: gn
 * @Date: 2020-11-24
 * @Description: redis实现的分布式锁
 */
@Component("gnRedisDistributedLock")
@Slf4j
public class RedisDistributedLock implements DistributedLock {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean tryLock(String lockName, long expiredTime) {
        String threadName = Thread.currentThread().getName();
        lockName = String.format("%s:Lock:%s", "GN", lockName);
        log.info("lockName:{}, threadName:{}", lockName, threadName);
        boolean result = false;
        if (!StringUtils.isEmpty(lockName)) {
            try {
                result = redisTemplate.opsForValue().setIfAbsent(lockName,
                        threadName, expiredTime, TimeUnit.SECONDS);
            } catch (Exception e) {
                log.error("tryLock获取锁失败:", e);
                result = false;
            }
        }
        return result;
    }

    @Override
    public boolean unlock(String lockName) {
        try {
            lockName = String.format("%s:Lock:%s", "GN", lockName);
            log.info("lockName:{}", lockName);
            return redisTemplate.delete(lockName);
        } catch (Exception e) {
            log.error("unlock 释放锁失败:", e);
            return false;
        }
    }
}
