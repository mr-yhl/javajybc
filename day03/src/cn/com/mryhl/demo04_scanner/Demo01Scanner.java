package cn.com.mryhl.demo04_scanner;
/*
Scanner录入存在的问题
同一个Scanner对象，如果既调用nextLine键盘录入字符串，又调用其他的nextXxx方法，就有可能引发问题。
nextInt,nextDouble...:这些方法都会逐个使用自己的回车。
nextLine:能够检测到其他方法的回车。
解决方案：
给nextInt,nextDouble单独创建一个Scanner对象
给nextLine单独创建一个对象。
 */

import java.util.Scanner;

public class Demo01Scanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("num"+num);
        String s = scanner1.nextLine();
        System.out.println("s:"+s);
    }
}
