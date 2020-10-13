package com.gn.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Auther: gn
 * @Date: 2020-5-23 09:31
 * @Description:
 */
@Data
@Builder
public class Student {
    private String name;
    private String age;

    public static void main(String[] args) {
//        SingleObject singleObject = SingleObject.getIn();
//        singleObject.showMsg();
//        SingleObject2 singleObject1 = SingleObject2.getSingleObject();
//        singleObject1.showMsg();
//        SingleObject3 instance = SingleObject3.getInstance();
//        instance.showMsg();
//        SingleObject5 singleObject5 = SingleObject5.SINGLE_OBJECT_5;
//        singleObject5.showMsg();
//        singleObject5.getSingleObject5();
        LinkedList<String> strings = new LinkedList<>();
        ArrayList<String> strings1 = new ArrayList<>();

        long l = System.currentTimeMillis();
        strings.add("花花1");
        strings.add("花花2");
        strings.add("花花3");
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        long l2 = System.currentTimeMillis();
        System.out.println("link:" + (l2-l));
        long a = System.currentTimeMillis();
        strings1.add("花花1");
        strings1.add("花花2");
        strings1.add("花花3");
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        long a2 = System.currentTimeMillis();
        System.out.println("array:" + (a2-a));

        long b = System.currentTimeMillis();
        String s = strings.get(1);
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        long b1 = System.currentTimeMillis();
        System.out.println("link.query:" + (b-b1) + "-结果：" + s);

        long c = System.currentTimeMillis();
        String d = strings1.get(1);
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        long c1 = System.currentTimeMillis();
        System.out.println("array.query:" + (c1-c) + "-结果：" + d);

    }
}
