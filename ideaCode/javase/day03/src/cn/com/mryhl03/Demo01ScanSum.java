package cn.com.mryhl03;

import java.util.Scanner;
/*
需求：
获取键盘录入的两个整数（int类型）数字，在控制台输出求和的结果。
实现步骤：
1.导包：import java.util.scanner
2.创建键盘录入对象：Scanner sc=new Scanner(System.in);
3.获取键盘录入的两个整数数字，分别保存到int变量a和b中
4.计算a和b中的数据之和工保存到int变量sum中
5.打印sum中的值
*/
public class Demo01ScanSum {
    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字:");
        a = sc.nextInt();
        System.out.println("请输入第二个数字:");
        b = sc.nextInt();
        int sum = a + b;
        System.out.println(a+"+"+b+"="+sum);
    }
}
