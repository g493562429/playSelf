package com.gn.demo.dto;

/**
 * @Auther: gn
 * @Date: 2020-5-26 23:59
 * @Description: 饿汉式单例模式（线程安全，支持多线程，会产生垃圾对象，通过类加载创建对象费内存）
 */
public class SingleObject2 {

    private static SingleObject2 singleObject = new SingleObject2();

    private SingleObject2() {
    }

    public static SingleObject2 getSingleObject() {
        return singleObject;
    }

    public void showMsg() {
        System.out.println("饿汉式单例模式");
    }
}
