package cn.com.mryhl.demo07_calender;
/*
在Calendar中有一个方法叫做add,可以对指定字段的值进行计算。
void add(int field, int amount):对指定字段的值进行计算。
参数field:对哪个字段进行计算。
参数amount:如何计
如果该数是一个正数，表示加上该值。2
如果该数是一个负数，表示减去该值。-2
 */


import java.util.Calendar;

public class Demo04CalendarAdd {
    public static void main(String[] args) {
        // 获取日历对象
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MARCH) + 1) + "-" + c.get(Calendar.DATE));
        // 对年字段进行计算
        c.add(Calendar.YEAR,2696);
        c.add(Calendar.MARCH,10);
        c.add(Calendar.DATE,12);
        System.out.println("黄帝历:"+c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MARCH) + 1) + "-" + c.get(Calendar.DATE));
    }
}
