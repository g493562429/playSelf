package com.gn.demo.controller;

/**
 * @Auther: gn
 * @Date: 2020-5-25 19:35
 * @Description: 选择排序
 */
public class SelectionSortController {
    public static void main(String[] args) {
        int[] arr = {69, 33, 43, 2, 8, 7, 0, -1};
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    //记录下数组中最小值的下标，arr[minIndex]为比较对象
                    minIndex = j;
                }
            }
            //交换最小值与当前i标的值进行交换，如果i标的值就是最小的，位置不会变
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        //打印输出
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
