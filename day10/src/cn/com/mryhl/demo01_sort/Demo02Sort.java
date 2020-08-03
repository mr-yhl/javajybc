package cn.com.mryhl.demo01_sort;

import java.util.Arrays;

/*
选择排序
 */
public class Demo02Sort {
    public static void main(String[] args) {
        // 定义一个数组
        int[] arr = {4, 3, 2, 1};

        // 选择排序
        for (int i = 0; i < arr.length - 1; i++) {
            // 内层循环
            for (int i1 = i + 1; i1 < arr.length; i1++) {
                // 比后面的大就交换
                if (arr[i] > arr[i1]) {
                    int temp = arr[i];
                    arr[i] = arr[i1];
                    arr[i1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
