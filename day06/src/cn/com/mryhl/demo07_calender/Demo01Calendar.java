package cn.com.mryhl.demo07_calender;

import java.util.Calendar;

/*
Calendar叫做日历类。
虽然他叫做日历类，但是他和Date一样，也可以表示精确的时间瞬间，精确到毫秒。
Calendar是一个抽象类，如果要用需要使用子类。
由于时间地区的敏感性,Calendar的子类对象(日历)不需要我们自己new,可以通过Calendar的静态方法获取
 Calendar中获取日历的方法
static Calendar getInstance():根据时区的设置获取一个日历对象。

 */
public class Demo01Calendar {
    public static void main(String[] args) {
        // 调用Calendar中的静态方法获取日历
        // Ctrl + Alt + v
        Calendar instance = Calendar.getInstance();
        //将日历对象输出
        System.out.println(instance);
    }
}
