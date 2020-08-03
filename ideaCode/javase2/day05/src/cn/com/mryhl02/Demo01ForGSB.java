package cn.com.mryhl02;

import java.util.Scanner;

// 键盘录入一个三位数字，获取个位，十位，百位，并输出
public class Demo01ForGSB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个三位数:");
        int num = sc.nextInt();
        if (num >= 100 && num <= 999) {
            int ge = num % 10;
            int shi = num / 10 % 10;
            int bai = num / 100 % 10;
            System.out.println("个位:" + ge + "十位:" + shi + "百位:" + bai);
        } else {
            System.out.println("您输入的数字" + num + "不是三位数");
        }
    }
}

