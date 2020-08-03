package cn.com.mryhl.demo03_foreach;
/*
在JDK5的时候，多了增强for舒环（foreach),可以遍历数组或者集合。
格式
for(数据类型 变量名：容器）(
)
解释
数据类型：要遍历的容器中保存的是什么类型的数据，这个数据类型就写什么。
变量名：表示容器中的每一个元素。
容器：数组或者集合。
通过增强for遍历数组
增强for是一种语法糖，语法糖指的是本质没有变，只不过写法更加优雅，更加简洁了。
增强for遍历数组本质还是之前的普通for循环
 */

import java.util.Arrays;

public class Demo01Foreach {
    public static void main(String[] args) {
        // 创建数组
        int[] intArr = {11,33,44,55};
        for (int a:intArr){
            // 变量a表示数组中的每一个元素
            System.out.println(a);
        }
        System.out.println("遍历double数组=====================");
        //遍历double数组
        double[] doubleArr = {2.4,5.6,78.9,33.4};
        for (double num :doubleArr){
            System.out.println(num);
        }

        int[] arr = {10,20,30,40,50,60};
        for (int num:arr)
            num*=2;
        System.out.println(Arrays.toString(arr));

    }
}
