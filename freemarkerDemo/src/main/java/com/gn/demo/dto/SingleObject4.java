package com.gn.demo.dto;

/**
 * @Auther: gn
 * @Date: 2020-5-27 00:25
 * @Description: 登记式/静态内部类
 */
public class SingleObject4 {
    private static class SingleObjectHolder {
        private static final SingleObject4 SINGLE_OBJECT_4 = new SingleObject4();
    }

    private SingleObject4() {
    }

    public static SingleObject4 getInstance() {
        System.out.println("静态内部类单例模式生成了");
        return SingleObjectHolder.SINGLE_OBJECT_4;
    }

    public void showMsg(){
        System.out.println("静态内部类单例模式msg");
    }
}
