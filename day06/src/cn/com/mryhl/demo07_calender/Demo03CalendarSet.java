package cn.com.mryhl.demo07_calender;
/*
在Calendar中有一个方法叫做set,可以设置指定字段的值。
    void set(int field, int value):给指定字段设置值。
        参数field:给哪个字段设置值。
        参数vaLue:设置成什么值
 */


import java.util.Calendar;

public class Demo03CalendarSet {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MARCH) + 1) + "-" + c.get(Calendar.DATE));
        // 重新设置值
        c.set(Calendar.YEAR,1912);
        c.set(Calendar.MARCH,0);
        c.set(Calendar.DATE,1);
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MARCH) + 1) + "-" + c.get(Calendar.DATE));
    }
}
