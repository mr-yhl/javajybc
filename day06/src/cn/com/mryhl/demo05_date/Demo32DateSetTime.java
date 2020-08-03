package cn.com.mryhl.demo05_date;

import java.util.Date;

/*
Date中的其他方法:
   void setTime():重新设置Date对象所表示的时间。参数是毫秒值，表示从1970年1月1日开始过了多少毫秒，
 */
public class Demo32DateSetTime {
    public static void main(String[] args) {
        //使用空参数构造方法创建的Date对象表示当前计算机的时间。
        Date date = new Date();
        System.out.println("date:"+date);
        date.setTime(899343l);
        System.out.println("date:"+date);


    }
}
