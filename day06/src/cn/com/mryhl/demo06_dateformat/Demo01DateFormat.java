package cn.com.mryhl.demo06_dateformat;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
如果我们希望将Date对象转成我们喜欢的格式然后进行输出，那么我们可以使用DateFormat进行格式化操作
格式化操作指的是将Date对象转成指定格式的字符申。

DateFormat是一个抽象类，如果要用，需要使用子类。最常用的子类是SimpleDateFormat
SimpleDateFormet(String pattern):参数要传递一个模式，会根据指定的模式创建SimpleDateFormat对象。
模式其实就是要转换的格式：
    最终要转换的格式：   2000年10月24日 14时12分23秒
模式：
                     yyyy年MM月dd日 HH时mm分ss秒
模式其实就是要使用英文字母替换掉格式中的数字
年：y
月：M
日：d
时：H(24)   h(12)
秒：s

SimpleDateFormet的其他方法:
String format(Date date):将参数Date对象根据指定的模式转成字符申并返回。


 将Date转String步骤:
    1.创建Date对象
    2.创建SimpLeDateFormat对象【转换器】
    3.调用SimpleDateFormat中的format方法，将Date转成字符串。


 */
public class Demo01DateFormat {
    public static void main(String[] args) {
        // 创建Date对象
        Date date = new Date();
        // 创建SimpLeDateFormat对象【转换器】
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        // 调用SimpleDateFormat中的format方法，将Date转成字符串。
        System.out.println(simpleDateFormat.format(date));//2020年07月26日 11时31分40秒
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat1.format(date));//20-07-26 11:33:13
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("y-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat2.format(date));//2020-07-26 11:33:13
    }

}
