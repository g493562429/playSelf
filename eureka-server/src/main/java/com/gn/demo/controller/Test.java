package com.gn.demo.controller;

/**
 * @Author: gn
 * @Date: 2020-9-9
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int n = 1;
        int c = 0;
        if (n == 1){
            c = 1;
            System.out.println(c);
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println(c);
    }
}
