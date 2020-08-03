package com.itheima03;

/*
    无返回值有参数的方法练习-打印数字是否是偶数
        1.无返回值
            经验分享:
                如果在题目需求中能够明确看到打印/输出/遍历二字,说明方法不需要返回结果数据,直接打印结果即可
                方法内部不需要返回值,返回值类型必须写为void

        2.有参数
            经验分享: 如果题目需求中有不确定的东西,就需要定义参数列表

        3.注意:
            (1)方法定义完毕后,不调用是不会执行的
            (2)调用格式:
                方法名称(参数列表...)
            (3)方法定义完毕后,可以调用任意多次

        4.练习:
	        定义一个方法，该方法接收一个int参数，方法内部打印输出该数据是否是偶数

	    5.三要素:
	        (1)方法名称:    printOu
	        (2)参数列表:    int num
	        (3)返回值类型:  void
 */
public class Demo02PrintOu {
    public static void main(String[] args) {

        System.out.println("main...start...");

        //调用printOu方法: 传递常量
        printOu(10 );

        //调用printOu方法: 传递变量
        int a = 11;

        printOu(a);

        System.out.println("main...end...");

    }

    //定义一个方法，该方法接收一个int参数，方法内部打印输出该数据是否是偶数
    public static void printOu(int num) {

        boolean result = (num % 2 == 0) ? true : false;

        System.out.println(num+"是偶数吗? "+result);

        return ;//结束方法的调用,返回到方法的调用处
    }

}
