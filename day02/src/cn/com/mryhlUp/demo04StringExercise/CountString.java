package cn.com.mryhlUp.demo04StringExercise;
/*
请编写程序，由键盘录入一个字符串，统计字符串中英文字母和数字分别有多少个。比如：Hello12345World中字母：10个，数字：5个。
 */

import java.util.Scanner;

public class CountString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一串字符串");
        String s = scanner.nextLine();
        int countWord=0,countNumber=0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >='A'&& ch <='Z')||(ch >='a'&& ch <='z'))
                countWord++;
            if (ch >='0'&& ch <='9')
                countNumber++;
        }
        System.out.println(s + "这串字符串中,共有字母" + countWord + "个,数字" + countNumber + "个");

    }
}
