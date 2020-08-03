package cn.com.mryhl.demo06_dateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
如果想要将时间字符申转成一个Date对象，我们也可以使用simpleDateFormat去完成，如果字器申转Date,一般叫做解析。

SimpleDateFormat中解析的方法：
    Date parse(String source):将字符申转成Date并返回。

解析的步骤：
    1.定义一个字符申表示时间。
    2.创建SimpleDateFormat对象【转换器】
    3.调用parse方法，将字符串转成Date
注意:
    1. SimpLeDateFormat构造方法中的模式，必须要和字符串的格式一致
    2.调用完parse方法会出现红线，原因是因为parse方法需要处理异常【后期讲解】现在做法是把光标放到红线上，然后按alt+回车，选择第一个

 小结：
    Date->String:格式化，SimpLeDateFormat中的format方法完成。
    String->Date:解析，SimpLeDateFormat中的parse方法完成。

 */
public class Demo02DateFormat {
    public static void main(String[] args) throws ParseException {
        // 定义一个字符申表示时间。
        String s = "2020-07-26 11:35:20";
        // 创建SimpleDateFormat对象【转换器】
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 调用parse方法，将字符串转成Date
        Date parse = simpleDateFormat.parse(s);

        System.out.println(parse);
    }

}
