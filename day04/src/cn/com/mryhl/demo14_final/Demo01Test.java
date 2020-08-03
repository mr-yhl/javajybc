package cn.com.mryhl.demo14_final;
/*
final关键字
final可以看成最终的，可以修饰类，修饰方法，修饰变量。
如果final修饰类，这个类不能被继承，但是可以继承其他类
如果final修饰方法，这个方法不能被重写,但可以被子类继承使用
如果final修饰变量，这个变量的值不可改变，从效果上看，它其实就是一个常量。
    如果final修饰局部变量,变量的值只能赋值一次,一旦赋值,不可改变
    final修饰成员变量,变量的值只能赋值一次,一旦赋值不能改变.
    final修饰的成员变量，必须在创建对象之前完成赋值（可以直接赋值，也可以构造方法中赋值）
final修饰变量后,改变量就是常量了,常量命名规范  全部大写,单词用_隔开
 */

public class Demo01Test {
    public static void main(String[] args) {
        Zi zi = new Zi();
        zi.method();
        //定义变量,用final修饰
        final int i;
        i = 10;
        System.out.println(i);

        /*final int i=5;
        i = 10;
        System.out.println(i);*/
    }
}
