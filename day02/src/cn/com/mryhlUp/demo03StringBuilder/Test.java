package cn.com.mryhlUp.demo03StringBuilder;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        String[] ss = {"笨蛋","尼玛","傻瓜"};
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.nextLine();
        String strFilter = filter(str,ss);
        System.out.println("过滤后的字符串为：" + strFilter);
    }

    private static String filter(String str , String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            str = str.replace(strings[i],"**");
        }
        return str;
    }
}
