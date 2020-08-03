package cn.com.mryhl01.demo02_date.d02;
/*
请编写程序，从控制台分别接收两个“生日”，
格式：yyyy年MM月dd日，程序要能够计算并打印：
第一个生日大于/小于第二个生日。
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Demo01Bijiao {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个的生日,格式(yyyy年MM月dd日)");
        String birthday = sc.nextLine();
        System.out.println("请输入第二个的生日,格式(yyyy年MM月dd日)");
        String birthday1 = sc.nextLine();
        SimpleDateFormat sr = new SimpleDateFormat("yyyy年MM月dd日");
        Date parse = sr.parse(birthday);
        Date parse1 = sr.parse(birthday1);
        if (parse.before(parse1))
            System.out.println("第一个人的生日大于第二个人");
        else
            System.out.println("第一个人的生日小于第二个人");
    }
}
