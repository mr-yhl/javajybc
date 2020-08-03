package cn.com.mryhl;
/*
工具类
定义方法：
用来根据字符串类型的出生日期得到年龄
工具类里面的方法为了方便使用，一般会定义成静态的
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

    /*
    定义方法，用来将生日转换成年龄
参数：String【字符申类型的生日】
返回值类型：int 【int类型的年龄】
     */
    public static int sumAge(String birthday) {
        /*
            思路：
                1.创建SimpleDateFormat对象，指定模式，用来转换
                2.将出生日期的字符申转成一个Date对象。
                3.通过Calendar 的getInstance获取日历对象，该日历对象表示的是当前时间。
                4.获取当前时间的年月日信息。
                5.通过calendar调用setTime,根据Date对象重新设置Calendar的时间。
                6.获取出生日期的年月日信息
                7.计算年龄
         */
        SimpleDateFormat spt = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = spt.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar instance = Calendar.getInstance();
        int nowyear = instance.get(Calendar.YEAR);
        int nowmonth = instance.get(Calendar.MARCH)+1;
        int nowday = instance.get(Calendar.DATE);

        instance.setTime(date1);
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MARCH)+1;
        int day = instance.get(Calendar.DATE);

        int age = nowyear-year;
        if(month>nowmonth){
            age--;
        }else if(month==nowmonth&&day>nowday)
            age--;
        return age;

    }
}
