package cn.com.mryhl.demo13_wrap;
/*
每一种基本类型都有其对应的引用类型，这个对应的引用类型叫做包装类。

    基本类型        引用类型（包装类）
    byte            Byte
    short           Short
    int             Integer（特殊）
    long            Long
    float           Float
    double          Double
    boolean         Boolean
    char            Character（特殊）
    基本类型和对应的包装类使用方式基本一致。
    基本类型只是一些简单的数据，只能直接使用或者进行运算，无法调用方法，优点效率高
    包装类是引用类型，可以创建对象，并且可以调用方法,功能比较强大

在JDK5的时候，多了一个新的特性，叫做自动拆装箱。
        拆箱： 包装类类型转成对应的基本类型。
        装箱： 基本类型转成对应的包装类类型。

    有了自动拆装箱后，基本类型以及包装类类型可以自动转换。

 */

public class Demo01Wrap {
    public static void main(String[] args) {
        // 自动装箱:10默认是int类型，把int类型的10赋值给Integer类型，那么基本类型会自动变成对应的包装类类型
        Integer a = 10;
        // 自动装箱:20默认是int类型，把int类型的20赋值给Integer类型，那么基本类型会自动变成对应的包装类类型

        Integer b = 20;
        // 自动拆箱:Integer类型的a和会先把自己转成int类型，然后再去进行运算。此时包装类型转成基本类型就是拆箱。
        // 自动装箱：a和相加的结果是int类型，把int类型的结果以赋值的方式交给Integer,基本类型int就转成了包装类类型

        Integer sum = a+b;
        System.out.println(sum);


    }
}
