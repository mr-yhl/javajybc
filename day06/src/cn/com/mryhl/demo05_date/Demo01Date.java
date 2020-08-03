package cn.com.mryhl.demo05_date;

import java.util.Date;

/*
Date(java.util.Date)类可以叫做时间日期类。
虽然叫做时间日期类，但是表示的是特定的时间瞬间，精确到毫秒。

构造方法:
    Date(): 使用空参数的构造方法会根据当前计算机的时间创建Date对象。
    Date(Lang aate):参教要传递Long类型的毫秒值，表示从1970年1月1日时0分0秒开始，过了多少毫秒。
中国是东八区时间,标准时间是格林尼治时间,比标准时间块八个时间.初始时间是1970年1月1日8时0分0秒
 */
public class Demo01Date {
    public static void main(String[] args) {
        //使用空参数构造方法创建的Date对象表示当前计算机的时间。
        Date date = new Date();
        System.out.println(date);
        // 创建Date对象,传long类型毫秒值
        Date date1 = new Date(15323632203l);
        System.out.println(date1);
    }
}
