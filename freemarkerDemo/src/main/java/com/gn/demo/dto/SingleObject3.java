package com.gn.demo.dto;

import java.util.HashMap;

/**
 * @Auther: gn
 * @Date: 2020-5-27 00:15
 * @Description: 双检锁/双重检验锁单例模式（DCL：double-checked locking）
 */
public class SingleObject3 {
    /**
     * JDK 版本：JDK1.5 起
     * <p>
     * 是否 Lazy 初始化：是
     * <p>
     * 是否多线程安全：是
     */
    private volatile static SingleObject3 singleObject3;

    private SingleObject3() {
    }

    public static SingleObject3 getInstance() {
        if (singleObject3 == null) {
            synchronized (SingleObject3.class) {
                if (singleObject3 == null) {
                    singleObject3 = new SingleObject3();
                    System.out.println("11111111111111");
                }
            }
        }
        return singleObject3;
    }

    public void showMsg() {
        System.out.println("双检锁/双重检验锁单例模式");

    }

}
