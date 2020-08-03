package cn.com.mryhl;

import java.util.Scanner;

// 键盘录入正数判断这个数是奇数还是偶数
public class JudgeParity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字:");
        int num = sc.nextInt();
        if(num%2==0)
            System.out.println(num+"是偶数");
        else
            System.out.println(num+"是奇数");
    }
}
