package com.gn.demo.controller;


/**
 * @Auther: gn
 * @Date: 2020-5-25 19:27
 * @Description: 冒泡排序
 */

public class BubbleSortController {
    public static void main(String[] args) {
        int[] arr = {9, 3, 5, 2, 8, 7, 0, -1};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }

        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
