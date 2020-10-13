package com.gn.demo.dto;

import java.lang.reflect.Field;

/**
 * @Author: gn
 * @Date: 2020-6-8 18:03
 * @Description:
 */
public class TicketWindow implements Runnable {
    /**
     * 车票总量
     */
    private int tickets = 100;
    /**
     * 计数器
     */
    private int count = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "准备出票,剩余票数:" + tickets + "张");
                    tickets--;
                    System.out.println(Thread.currentThread().getName() + "卖出一张,剩余票数:" + tickets + "张");
                    try {
                        Thread.sleep(100);
                        count++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "余票不足,停止售票!");
                    System.out.println(count);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Father father = Father.builder()
                .face("cool")
                .height("180")
                .life(new Life("alive"))
                .build();
        Field[] fields = Father.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            String name = field.getName();
            if ("face".equals(name)) {
                try {
                    field.set(father, "cool2");
                    System.out.println(father);
                    String updateValue = "cool3";
                    String updateValue2 = "cool4";
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            updateField(father, field, updateValue);
                        }
                    };
                    Runnable runnable1 = new Runnable() {
                        @Override
                        public void run() {

                        }
                    };
                    System.out.println(father);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
//            field.setAccessible(false);
        }
    }

    private static void updateField(Father father, Field field, String updateValue) {
        if ("face".equals(field.getName())) {
            try {
                field.set(father, updateValue);
                Thread.sleep(60000L);
                System.out.println(father);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
