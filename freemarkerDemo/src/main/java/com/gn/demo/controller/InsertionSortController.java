package com.gn.demo.controller;

/**
 * @Auther: gn
 * @Date: 2020-5-25 19:57
 * @Description: 插入排序
 */
public class InsertionSortController {
    public static void main(String[] args) {
        int[] arr = {19, 53, 25, 2, 8, 7, 0, -1};
        for (int i = 1; i < arr.length; i++) {
            //取出数组的第i个数的前一个下标，并记录下第i个数的值
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        //打印输出
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
