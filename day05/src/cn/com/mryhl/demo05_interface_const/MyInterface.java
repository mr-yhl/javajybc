package cn.com.mryhl.demo05_interface_const;
/*
接口中可以有成员变量，从效果上看，这个成员变量就是常量。
在任何版本的Java中，接口中都可以有常量。
常量的定义格式：
    public static final 数据类型 常量名 = 值;
因为使用final修饰了，所以不可以改变，我们就称为常量。

注意：
    1.接口中的常量public static final可以省略。
    2.如果省略public static final,那么常量也是用public static final修饰的。
    3.因为常量使用static修饰了，所以我们要通过接口名字直接去使用常量。
    4.接口中的常量值不能改变
    5.接口中的常量必须有默认值
    6.常量的命名规范,大写,下划线隔开

 */
public interface MyInterface {
    public static final int NUM = 10;

}
