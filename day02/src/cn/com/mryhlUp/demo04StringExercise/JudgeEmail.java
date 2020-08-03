package cn.com.mryhlUp.demo04StringExercise;
/*
 请用户从控制台输入一个“Email地址”，程序接收后判断此Email地址中是否包含@符号和.符号，
 如果全部包含，打印：合法，否则打印：不合法的Email地址。
 */

import java.util.Scanner;

public class JudgeEmail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入Email地址:");
        String s = scanner.nextLine();
        // boolean contains(String s):判断字符串中是否包含指定的内容。
        if (s.contains("@")&&s.contains(".")){
            System.out.println("合法");
        }else
            System.out.println("不合法的Email地址");
    }
}
