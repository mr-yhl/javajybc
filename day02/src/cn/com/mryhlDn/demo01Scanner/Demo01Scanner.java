package cn.com.mryhlDn.demo01Scanner;
/*
nextLong()
将输入的下一个标记扫描为 long 。
 */

import java.util.Scanner;

public class Demo01Scanner {
    public static void main(String[] args) {
        // 创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请你输入一个字符串");
        String Str = scanner.nextLine();
        System.out.println(Str);
    }
}
