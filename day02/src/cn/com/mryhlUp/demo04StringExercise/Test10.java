package cn.com.mryhlUp.demo04StringExercise;
/*
请用户从控制台输入一个java文件的名字，例如：Test.java，请编程实现以下功能：

Ø 判断此文件名是否以“.java”结尾，并打印结果

Ø 获取此文件中.符号的索引位置，并打印结果
 */

import java.util.Scanner;

public class Test10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文件名:");
        String s = scanner.nextLine();
        int i = s.lastIndexOf(".java");
        if (i!=-1)
            System.out.println("文件名正确,'.'的索引是" + i );
    }
}
