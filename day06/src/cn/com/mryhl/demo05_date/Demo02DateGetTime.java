package cn.com.mryhl.demo05_date;

import java.util.Date;

/*
Date中的方法:
    long getTime():获取Date对象对应的毫秒值【从1970年1月1日开始，到Date对象对应的时间过了多少毫秒】
 */
public class Demo02DateGetTime {
    public static void main(String[] args) {
        //使用空参数构造方法创建的Date对象表示当前计算机的时间。
        Date date = new Date();
        //从1970年1月1日开始，到Date对象对应的时间过了多少毫秒
        System.out.println(date.getTime());

    }
}
