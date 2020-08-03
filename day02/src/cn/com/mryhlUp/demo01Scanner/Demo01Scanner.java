package cn.com.mryhlUp.demo01Scanner;

import java.util.Scanner;

/*
    Scanner键盘录入字符串。

    如果要键盘录入字符串，那么需要使用下面的方法：
        String nextLine()： 键盘录入一个字符串
 */
public class Demo01Scanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String s = scanner.nextLine();
        System.out.println(s);
    }
}
