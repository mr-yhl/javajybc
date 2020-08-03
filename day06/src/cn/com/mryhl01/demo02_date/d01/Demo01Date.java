package cn.com.mryhl01.demo02_date.d01;
/*
请编写程序，从控制台接收一个“生日”，格式：yyyy-MM-dd，程序要能够计算并打印他来到世界xx天。
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class Demo01Date {
    public static void main(String[] args) throws ParseException {
        // 输入生日
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的生日,格式(yyyy-MM-dd)");
        String birthday = sc.nextLine();
        SimpleDateFormat sr = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sr.parse(birthday);
        Date today = new Date();
        if (!today.after(parse)){
            System.out.println("未出生,结束");
            return;
        }
        long l = today.getTime() - parse.getTime();
        long l1 = l / 1000 / 60 / 60 / 24;
        System.out.println("已经出生" + l1 + "天");


    }
}
