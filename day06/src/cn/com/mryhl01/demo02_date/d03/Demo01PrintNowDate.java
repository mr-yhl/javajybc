package cn.com.mryhl01.demo02_date.d03;
/*
请在控制台以“xxxx年xx月xx日 xx时xx分xx秒”的格式打印当前系统时间。
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo01PrintNowDate {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat =new  SimpleDateFormat("yyyy年MM月dd日  HH时mm分ss秒");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }
}
