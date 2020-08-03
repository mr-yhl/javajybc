package cn.com.mryhl03;

import java.util.Scanner;
public class Demo02ThreeMonksHighe {
    public static void main(String[] args) {
        /*
         一座寺庙里住着三个和尚，已知他们的身高分别为150cm、210cm、165cm,
         请用程序实现获取这三个和尚的最高身高。
        实现步骤：
        1.导包：import java.util.Scanner
        2.创建键盘录入Scanner类的对象：Scanner sc=new Scanner(System.in)
        3.获取键盘录入的三个整数数字，代表三个和尚的身高，分别保存到int变量h1,h2,h3中
        4.使用三元运算符计算h1和h2的最大值，保存到nt变量temp中
        5.使用三元运算符计算temp和h3的最大值，保存到int变量max中
        6.打印max的值
         */
        Scanner sc = new Scanner(System.in);
        int h1,h2,h3;
        System.out.println("请输入三个和尚的身高,回车键输入下一个数据:");
        h1 = sc.nextInt();
        h2 = sc.nextInt();
        h3 = sc.nextInt();
        int temp=(h1>h2)?h1:h2;
        int max=h3>temp?h3:temp;
        System.out.println("三个和尚的最大身高为"+max+"厘米");

    }
}
