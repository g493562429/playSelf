package com.gn.demo.dto;

/**
 * @Auther: gn
 * @Date: 2020-5-26 23:49
 * @Description: 懒汉式单例模式(线程安全，支持多线程，通过加锁实现效率慢)
 */
public class SingleObject {

    private static SingleObject in;

    private SingleObject() {
    }

    public static synchronized SingleObject getIn(){
        if(in == null){
            in = new SingleObject();
        }
        return in;
    }

    public void showMsg(){
        System.out.println("懒汉式单例模式");
    }
}
