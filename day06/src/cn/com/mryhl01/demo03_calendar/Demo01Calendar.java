package cn.com.mryhl01.demo03_calendar;

import java.util.Calendar;

/* 请编写程序，使用Calendar类获取日历对象，
   并分别获取年、月、日、小时、分、秒，并将它们打印到控制台。\
   */
public class Demo01Calendar {
       public static void main(String[] args) {
           Calendar instance = Calendar.getInstance();
           int year = instance.get(Calendar.YEAR);
           int month = instance.get(Calendar.MARCH);
           int day = instance.get(Calendar.DATE);
           int h = instance.get(Calendar.HOUR);
           int minute = instance.get(Calendar.MINUTE);
           int second = instance.get(Calendar.SECOND);
           System.out.println(year + "年" + month + "月" + day + "日" + h + "时" + minute + "分" + second + "秒");

       }
}
