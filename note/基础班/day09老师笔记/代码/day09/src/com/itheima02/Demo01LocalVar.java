package com.itheima02;
/*
    注意:
        1.基本类型变量a的值,赋值给基本类型变量b,其实是把变量a的值复制一份给变量b,
            之后不管如何修改变量b中的值,对变量a中的值是不会产生任何影响的

        2.局部变量:
            方法内部或者方法定义时()中定义的变量,称之为局部变量,只在方法内部有效,出了所在的方法就不能使用到了
 */
public class Demo01LocalVar {
    public static void main(String[] args) {
        int a = 10;
        int b;//定义,未赋值

        b = a;//把变量a的值赋值给变量b

        System.out.println("a="+a);//10
        System.out.println("b="+b);//10

        b*=10;

        System.out.println("a="+a);//10
        System.out.println("b="+b);//100

        //错误: m和n是在method方法中定义的,只能在method方法中有效
        //System.out.println(m);
        //System.out.println(n);


    }

    public static void method() {
        //错误: a和b是在main方法中定义的,只能在main方法中使用
        //System.out.println(a);
        //System.out.println(b);

        int m = 10, n = 20;

        int a = 1000, b = 2000;

        System.out.println(a);
        System.out.println(b);
    }
}
