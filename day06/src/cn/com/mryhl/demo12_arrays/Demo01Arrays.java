package cn.com.mryhl.demo12_arrays;
/*
Arrays是操作数组的工具类
    static String toString(数组）:将数组内容转成指定格式的字符申并返回
    static void sort(数组）:对数组中的内容进行排序。



 */

import java.util.Arrays;

public class Demo01Arrays {
    public static void main(String[] args) {

        // 创建数组
        int[] arr = {66,22,77,44,55};
        // 将数组的内容转成字符串
        String s = Arrays.toString(arr);
        System.out.println(s);
        // 通过Arrays的sort方法,对内容排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
