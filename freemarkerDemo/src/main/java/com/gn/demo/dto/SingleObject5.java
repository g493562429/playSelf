package com.gn.demo.dto;

/**
 * @Auther: gn
 * @Date: 2020-5-27 00:35
 * @Description: 枚举单例模式（不能通过 reflection attack 来调用私有构造方法）
 */
public enum SingleObject5 {
    SINGLE_OBJECT_5;

    public void getSingleObject5() {
        System.out.println("枚举单例模式");
    }

    public void showMsg(){
        System.out.println("枚举单例模式方法");
    }
}
