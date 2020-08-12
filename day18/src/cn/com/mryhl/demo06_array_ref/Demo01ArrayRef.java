package cn.com.mryhl.demo06_array_ref;
/*
数组的构造器引用

    数组的构造器引用在创建数组的时候使用。
    格式：
        数据类型[]::new
 */

import java.util.Arrays;

public class Demo01ArrayRef {
    public static void method(ArrayBuilder a) {
        int[] arr = a.createArray(10);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        //调用method方法，传递Lambda表达式
        method(len -> new int[len]);
        //使用方法引用
        method(int[]::new);
    }
}
