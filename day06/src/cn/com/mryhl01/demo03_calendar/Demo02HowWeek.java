package cn.com.mryhl01.demo03_calendar;

import java.util.Calendar;

// 请编程，计算并打印“1949年10月1日”那天是星期几？
public class Demo02HowWeek {
    public static void main(String[] args) {
        // Calendar instance = Calendar.getInstance();
        // instance.set(Calendar.YEAR,1949);
        // instance.set(Calendar.MARCH,9);
        // instance.set(Calendar.DATE,1);
        // int i = instance.get(Calendar.DAY_OF_WEEK);
        // String[] weekArray = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        // System.out.println(weekArray[i - 1]);

        //创建Calendar对象
        Calendar cla = Calendar.getInstance();
        //设置指定日期  月份要-1，所以设置的是9
        cla.set(1949, 9, 1);

        //定义一个数组存储星期
        String[] weekArray = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

        //获得星期值
        int week = cla.get(Calendar.DAY_OF_WEEK);

        //打印结果
        System.out.println(weekArray[week - 1]);


    }
}
