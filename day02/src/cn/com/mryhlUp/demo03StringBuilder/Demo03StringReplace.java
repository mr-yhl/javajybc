package cn.com.mryhlUp.demo03StringBuilder;

import java.util.Scanner;

/*
敏感词过滤。
现有敏感词[尼玛,笨蛋，傻瓜]
要求键盘录入一个字符串，将该字符串中的所有的敏感词都替换成**
 */
public class Demo03StringReplace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        /*String s = scanner.nextLine();
        String[] arr = {"尼玛","笨蛋","傻瓜"};
        for (int i = 0; i < arr.length; i++) {
            s = s.replace(arr[i],"**");
        }
        System.out.println(s);*/
        String s = scanner.nextLine();
        System.out.println(s);
        s=scanner.next();
        System.out.println(s);

    }

}
