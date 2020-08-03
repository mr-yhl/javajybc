package com.itheima01;
/*
    方法重载参数列表不同有哪些情况?
        1.参数数量不同
        2.参数类型不同
        3.多个类型,顺序不同

    记住:
        方法重载,名称相同后,看参数列表的本质区别(不含参数名称),和其它的任何东西无关
 */
public class Demo03OverLoadNotice {
    public static void main(String[] args) {

    }

    //1.该方法没有参数
    public static void method(){

    }

    //2.该方法有一个int类型参数
    //方法2有一个参数,方法1没有参数,参数数量不同可以构成重载
    public static void method(int a){

    }

    //3.该方法有两个int类型参数
    //方法2有一个参数,方法1没有参数,参数数量不同可以构成重载
    //方法3有两个参数,方法2有一个参数,参数数量不同可以构成重载
    public static void method(int a,int b){

    }

    //4.该方法有一个double类型参数
    //方法4有一个double类型参数,方法2有一个int类型参数,参数类型不同可以构成重载
    public static void method(double a){

    }

    //5.该方法有一个double类型参数和一个int类型参数
    public static void method(double a, int b) {

    }

    //6.该方法有一个int类型参数和一个double类型参数
    //方法6的参数是先int类型后double类型,方法5的参数是先double类型,后int类型
    //方法参数有多个类型,但是顺序不同,可以构成重载
    public static void method(int a, double b) {

    }
}
