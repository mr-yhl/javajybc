package cn.com.mryhl.demo01_sort;

import java.util.Arrays;

/*
可以将数组中的内容按照顺序排列
数组：[4,3,2,1]排序之后：[1,2,3,4]
 */
public class Demo01Sort {
    public static void main(String[] args) {
        // 创建数组
        int[] arr = {4, 3, 2, 1};
        // 冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {

            //第一轮...
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 我们把前面数的索引看出i后面的看成i+1
                // 让索引为i的元素和索引为i+1的元素进行比较，如果前面的元素比后面元素大，就交换
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;

            }
        }
        System.out.println(Arrays.toString(arr));
        // [1, 2, 3, 4]
    }
}
