package com.itheima04;

/*
    有返回值有参数的方法练习-获取最大值
        1.有返回值
            经验分享:
                如果在题目需求中能够明确看到获取/返回/判断二字,说明方法内部需要返回结果数据,就必须定义返回值类型


        2.有参数
            经验分享: 如果题目需求中有不确定的东西,就需要定义参数列表

        3.注意:
            (1)方法定义完毕后,不调用是不会执行的
            (2)调用格式:
                方法名称(参数列表...)
            (3)方法定义完毕后,可以调用任意多次

        4.练习:
	        设计一个方法可以获取两个int数的较大值，数据来自于参数

	    5.三要素:
	        (1)方法名称:    getMax
	        (2)参数列表:    int a,int b
	        (3)返回值类型:  int
 */
public class Demo01GetMax {
    public static void main(String[] args) {

        System.out.println("main...start...");

        //调用方法getMax: 传递常量
        int result = getMax(10 , 20 );

        System.out.println("最大值: "+result);


        int m = 10;
        int n = 20;

        //调用方法getMax: 传递变量
        int result2 = getMax(m , n );
        System.out.println(m+"和"+n+"的最大值: "+result2);

        System.out.println("main...end...");

    }

    //设计一个方法可以获取两个int数的较大值，数据来自于参数
    /*
        你调用我的方法getMax时,必须给我传递两个int数据,
        我方法内部功能代码执行完毕后,会返还给你一个int类型的结果数据
        你: 代表方法的调用者
        我: 方法本身
     */
    public static int getMax(int a , int b ) {

        int max = (a > b) ? a : b;

        return max;//结束方法的调用,把max中的结果数据返回给方法的调用者
    }
}
