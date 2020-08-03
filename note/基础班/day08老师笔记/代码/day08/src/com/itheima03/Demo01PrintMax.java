package com.itheima03;

/*
    无返回值有参数的方法练习-打印最大值
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
	        定义一个方法用于打印两个int数中的较大数，数据来自于方法参数

	    5.三要素:
	        (1)方法名称:    printMax
	        (2)参数列表:    int a,int b
	        (3)返回值类型:  void
 */
public class Demo01PrintMax {
    public static void main(String[] args) {

        System.out.println("main...start...");

        //调用方法printMax: 传递常量
        printMax( 10 , 20 );

        System.out.println("main...end...");

    }

    //定义一个方法用于打印两个int数中的较大数，数据来自于方法参数
    /*
        你调用我的方法printOu时,必须给我传递两个int数据,
        我方法内部功能代码执行完毕后,没有结果数据返回给你,内部会直接打印结果数据
        你: 代表方法的调用者
        我: 方法本身
     */
    public static void printMax(int a, int b) {

        int max = (a > b) ? a : b;

        System.out.println("最大值: "+max);

        return ;//结束方法,返回到方法的调用处
    }
}
