package cn.com.mryhl02;

import java.util.Scanner;

/* 需求：
        任意给出两个整数，请用程序实现求出两个整数的最大值，并输出到控制台。
        实现步骤：
        1.创建键盘录入Scanner类的对象
        2.获取键盘录入的两个整数数字，分别保存到两个int变量a和b中
        3.定义int变量max,用来保存较大值的
        4.使用if语句的第二种格式对a和b的大小关系进行判断
        (1)如果a大于b说明a是较大的把a的值赋值给max
        (2)否则（a小于或者等于b)说明b是较大的把b的值赋值给max
        5.打印max的值
        */
public class Demo03IfElseMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, max;
        System.out.println("请输入第一个数:");
        a = sc.nextInt();
        System.out.println("请输入第二个数:");
        b = sc.nextInt();
        if (a > b)
            max = a;
        else
            max = b;
        System.out.println("两个整数" + a + "和" + b + "的最大值是" + max);
    }
}
