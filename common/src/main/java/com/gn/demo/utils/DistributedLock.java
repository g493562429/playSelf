package com.gn.demo.utils;

/**
 * @Author: gn
 * @Date: 2020-11-24
 * @Description: 分布式锁
 */
public interface DistributedLock {
    /**
     * 获取锁
     * @param lockName 锁的名字
     * @param expiredTime redis key的过期时间，锁的过期时间
     * @return 是否获取锁成功
     */
    boolean tryLock(String lockName, long expiredTime);

    /**
     * 释放锁
     * @param lockName 锁的名字
     * @return 是否释放锁成功
     */
    boolean unlock(String lockName);
}
