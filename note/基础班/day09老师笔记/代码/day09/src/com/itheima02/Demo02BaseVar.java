package com.itheima02;
/*
    基本类型作为方法参数传递的特点【形参的改变，不会影响实参】
        1.基本类型变量保存的具体的数据值,进行赋值时,传递的也是具体的数据值
        2.基本类型作为方法参数时,形式参数的改变,不会影响实际参数
            形式参数: 定义方法时,()中定义的参数(1个/多个变量),叫做形式参数 定义时是没有值的
            实际参数: 调用方法时,()中指定的数据(常量/变量),叫做实际参数	使用时必须是有值的

    注意:
        1.方法的执行都有自己独立的栈内存空间
        2.方法内部定义的变量也有独立的内存空间
        3.不同的方法中可以定义同名的变量,
            因为所在的方法的栈内存空间不同,
            同名变量的内存空间也不同,
            它们之间是互不干扰,互不影响
 */
public class Demo02BaseVar {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("ms..a="+a);//10
        System.out.println("ms..b="+b);//20
        change( a , b );//a和b叫做实际参数
        System.out.println("me..a="+a);//10
        System.out.println("me..b="+b);//20
    }

    public static void change(int a, int b) {//a和b叫做形式参数
        System.out.println("cs..a="+a);//10
        System.out.println("cs..b="+b);//20
        a = a * 10;
        b = b * 10;
        System.out.println("ce..a="+a);//100
        System.out.println("ce..b="+b);//200
        return ;
    }
}
