package cn.com.mryhl.demo07_calender;

import java.util.Calendar;

/*

在CaLendar中有一个方法叫做get,可以获取指定字段值
int get(int field):获取日历中指定字段的值并返回。
举例：
    get(年）:获取年的数据
    get(月）:获取月的数据
    get(日）:获取日的数据
get方法的参数是int类型，所以要传递int数字。我们可以使用int数字表示日历中的指定字段。
但是如果每次调用get方法，都传递数字，阅读性就会非常非常
在CaLendar中给我们提供了很多静态常量，这些经常常量是一些数字，并且根据常量名可以起到见名知意
的作用。在调用get方法时，最好传递这些常量
Calendar.YEAR:年
Calendar.MONTH:月
Calendar.DATE:日
注意：Calendar中的月份是从0开始的，范围是0到11。比我们生活中的月份要少1.
 */
public class Demo02CalendarGet {
    public static void main(String[] args) {
        // 调用Calendar中的静态方法获取日历
        // Ctrl + Alt + v
        Calendar c = Calendar.getInstance();
        // 获取指定字段的数据
        int i = c.get(Calendar.YEAR)-1949;
        //将日历对象输出
        System.out.println("现在是共和国"+i+"年");
        int i1 = c.get(Calendar.MARCH);
        System.out.println("现在是低"+(i1 + 1)+"月");
        int i2 = c.get(Calendar.DATE);
        System.out.println("day:" + i2);
    }
}
