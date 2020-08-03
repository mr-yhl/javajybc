package cn.com.mryhl02;

import java.util.Scanner;

public class Demo02IfElseJiOu {
    public static void main(String[] args) {
        //任意给出一个整数，请用程序实现判断该整数是奇数还是偶数，
        // 并在控制台输出该整数是奇数还是偶数。
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字:");
        int a = sc.nextInt();
        if (a % 2 == 0)
            System.out.println(a + "是偶数");
        else
            System.out.println(a + "是奇数");
    }
}
