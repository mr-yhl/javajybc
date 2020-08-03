package cn.com.mryhl.demo13_wrap;
/*
基本类型和字符申的相互转换
基本类型->字符串
    1.直接在基本类型数据后面加上“”    1+"abc"->  "1abc"
    2.调用String的静态方法valueOf
        static string valueof(任何类型）:将数据转成字符串并返回。
 字符串 -> 基本类型
        我们可以使用基本类型对应包装类的静态方法parseXXX完成。

        除了Character每个包装类中都有一个静态方法ParseXxx,可以把字符串转成对应的基本类型。
        如果要将字符串转成int类型，那么就是Integer中的静态方法parseInt完成。
        如果要将字符串转成double类型，那么就使用Double中的静态方法parseDouble完成。
        如果要讲字符串转成long类型，那么就使用Long中的静态方法parseLong完成。

        要把String转成int类型，使用Integer中的parseInt方法进行转换。
        要把string转成Long类型，使用Long中的parseLong方法进行转换。
        要把String转成double类型，使用DoubLe中的parseDouble方法进行转换
 */

public class Demo04Parse {
    public static void main(String[] args) {
        int num = 10;
        String str = num + "";
        System.out.println(str);
        String str1 = String.valueOf(num);
        System.out.println(str1);

        String ss = "231445";
        int basicNum = Integer.parseInt(ss);
        System.out.println(basicNum);
    }
}
