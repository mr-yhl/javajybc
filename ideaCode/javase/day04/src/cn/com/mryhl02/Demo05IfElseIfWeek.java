package cn.com.mryhl02;

import java.util.Scanner;

/*   需求：
        键盘录入一个星期数（1,2,...7),输出对应的星期一，星期二，…星期日
        演示效果：
        输入1输出星期-I
        输入2输出星期二
        输入3输出星期三
        输入4输出星期四
        输入5输出星期五
        输入6输出星期六
        输入7输出星期日
        输入其它数字输出数字有误*/
public class Demo05IfElseIfWeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入1-7之间的整数数字:");
        int week = sc.nextInt();
        if (week == 1)
            System.out.println("星期一");
        else if (week == 2)
            System.out.println("星期二");
        else if (week == 3)
            System.out.println("星期三");
        else if (week == 4)
            System.out.println("星期四");
        else if (week == 5)
            System.out.println("星期五");
        else if (week == 6)
            System.out.println("星期六");
        else if (week == 7)
            System.out.println("星期日");
        else
            System.out.println("输入错误");
        System.out.println("main        end");
    }
}
