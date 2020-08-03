package com.itheima05;
/*
    没有返回值的方法调用方式
        1.直接/单独/独立调用        没有返回值方法,只能采用直接调用,另外两种调用方式都是错误的
            方法名称(参数列表...);

        2.赋值调用: 把调用有返回值的方法的返回结果保存到变量中                   错误的
            数据类型 变量名称 = 方法名称(参数列表...);

        3.打印/输出调用:                                                     错误的
            System.out.println(方法名称(参数列表...));


 */
public class Demo04MethodInvoke {
    public static void main(String[] args) {
        System.out.println("main...start...");

        //1.直接/单独/独立调用        没有返回值方法,只能采用直接调用,另外两种调用方式都是错误的
        printSum(10,20);


        //2.赋值调用: 错误的
        //int result = printSum(10,20);//错误,printSum方法内部根本没有返回int数字

        //void v = printSum(10,20);//错误,void根本不是数据类型

        //3.打印调用: 错误的
        //System.out.println(void);
        //System.out.println(printSum());//printSum方法没有返回值,println方法也不知道到底要打印什么东西

        System.out.println("main...end...");
    }

    //定义方法,打印两个int数据之和
    public static void printSum(int a, int b) {

        int sum = a + b;

        System.out.println("和: "+sum);

        return ;//结束方法,返回到方法的调用处
    }
}
