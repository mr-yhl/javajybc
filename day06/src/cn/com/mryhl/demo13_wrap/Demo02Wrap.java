package cn.com.mryhl.demo13_wrap;
/*
 在JDK5之前，如果基本类型和对应的包装类进行转换，需要使用手动拆装箱。

    手动装箱（int -> Integer）
        使用包装类的静态方法valueOf即可。
        static Integer valueOf(int i)：接受一个int类型的数据，返回Integer类型的结果。
    手动拆箱（Integer -> int）
        使用包装类的方法intValue实现
        int intValue()：将Integer对象转成int数字并返回
 */

public class Demo02Wrap {
    public static void main(String[] args) {
       int a = 10;
        Integer integer = Integer.valueOf(a);
        System.out.println(integer);
        int i = integer.intValue();
        System.out.println(i);
    }
}
