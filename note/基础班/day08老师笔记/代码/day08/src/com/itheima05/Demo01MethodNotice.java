package com.itheima05;

import java.util.Scanner;

/*
    方法的注意事项一
        1.方法不能嵌套定义(在定义方法的内部又定义了其它方法),可以调用其它方法
        2.方法可以嵌套调用
        3.定义方法时参数列表根据需求确定(可以有0个/1个/2个/3个...)
        4.如果方法需要参数列表,参数列表中定义的变量的类型根据需求确定
            可以是基本类型/引用类型

        5.定义方法时返回值类型根据需求确定
            如果没有返回值,返回值类型固定写为void

        6.如果分析后发现方法需要返回值类型,那么返回值类型也可以是基本类型/引用类型

        7.不管方法的返回值类型基本类型还是引用类型,返回的结果数据只能有一个,不能有多个
            如果需要返回多个数据,那么必须把多个数据放入数组/集合(就业班讲)中,返回一个数组/集合


 */
public class Demo01MethodNotice {
    public static void main(String[] args) {
        a();

        //调用方法获取int数字,保存到int变量num中
        int num = getNum();

        //调用方法传递int数字
        printNum(num);

        //以上两行方法的调用,可以合并成一行
        //2.方法可以嵌套调用
        printNum(getNum());
    }
    //1.方法不能嵌套定义(在定义方法的内部又定义了其它方法),可以调用其它方法
    public static void a() {
        //错误: 不能在方法内部,再定义其它方法
        /*public static void b() {

        }*/
        System.out.println("a...");
        c();
        return ;
    }

    public static void c() {
        System.out.println("c...");
        return ;
    }

    //2.方法可以嵌套调用
    //定义方法内部返回int数字
    public static int getNum() {
        return 100;
    }

    //定义方法定义,int数字
    public static void printNum(int a) {
        System.out.println(a);
    }

    //3.定义方法时参数列表根据需求确定(可以有0个/1个/2个/3个...)
    //4.如果方法需要参数列表,参数列表中定义的变量的类型根据需求确定
    //可以是基本类型/引用类型
    public static void d(int a, double b, int[] array, Scanner scanner) {

    }

    //5.定义方法时返回值类型根据需求确定
    //如果没有返回值,返回值类型固定写为void
    public static int e() {//返回值类型是基本类型
        return 100;
    }

    public static Scanner f() {//返回值类型是引用类型
        return new Scanner(System.in);
    }

    //如果要返回多个数据,必须把多个数据放到数组中
    //返回的仍然是一个数据,只不过返回的是数组容器而已,该容器中存储了多个数据
    public static int[] g() {
        return new int[] {100,200,300};
    }
}
