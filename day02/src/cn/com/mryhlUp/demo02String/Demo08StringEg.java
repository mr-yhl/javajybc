package cn.com.mryhlUp.demo02String;
/*

    统计字符次数
        键盘录入一个字符串，统计该字符串中大写字母字符，小写字母字符，数字字符出现的次数(不统计其他字符)

    思路：
        1. 键盘录入一个字符串。
        2. 定义三个变量表示计数器，分别统计大写字母，小写字母，以及数字字符的个数。
        3. 遍历字符串，拿到字符串中的每一个字符。
        4. 判断这个字符是大写字母还是小写字母还是数字，并且把对应的计数器自增。
        5. 输出计数器的内容。

    ctrl + alt + v： 可以直接生成方法后的结果
 */

import java.util.Scanner;

public class Demo08StringEg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String s = scanner.nextLine();
        int num=0,dz=0,xz=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c>='a' && c<='z')
                xz++;
            if(c>='0'&& c<='9')
                num++;
            if(c>='A' && c<='Z')
                dz++;
        }
        System.out.println("存在数字" + num + "个,小写字母" + xz + "个,大写字母" + dz + "个");
    }
}
