package cn.com.mryhl01.demo02_date.d04;
/*
 请编写程序，从控制台接收一个“日期”，格式：yyyy-MM-dd，
 程序将其转换为：xxxx年xx月xx日的格式输出到控制台。
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Demo01DateToDate {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入日期,格式(yyyy-MM-dd)");
        String today = sc.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(today);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy年MM月dd日");
        String format = simpleDateFormat1.format(parse);
        System.out.println(format);
    }
}
