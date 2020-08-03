package cn.com.mryhlUp.demo04StringExercise;
/*
程序从控制台接收一个java文件的文件名，例如：test.java，TEST.java，tEst.JAVA，请编程实现以下功能：

​	获取，并打印文件名的第一个字符；

​	获取，并打印文件的后缀名(包括.符号)，例如：.java

​	无论原文件名什么样，最终将其转换为：Test.java的形式，打印转换后的文件名。
 */

import java.util.Scanner;

public class StringPlus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个文件名:");
        String s = scanner.nextLine();
        printString(s);
    }
    public static void printString(String s){
        // char c = s.charAt(0);
        String substring1 = s.substring(0, 1);
        System.out.println("文件名的第一个字符为:" + substring1);
        String substring = s.substring(s.lastIndexOf("."));
        System.out.println("文件的拓展名为" + substring);
        System.out.println(substring1.toUpperCase() + s.substring(1).toLowerCase());

    }
}
