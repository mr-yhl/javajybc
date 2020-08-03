package com.itheima04;

/*
    有返回值有参数的方法练习-获取数字是否是偶数
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
	        定义一个方法，该方法接收一个int参数，判断该数据是否是偶数，并返回真假值

	    5.三要素:
	        (1)方法名称:    getOu
	        (2)参数列表:    int num
	        (3)返回值类型:  boolean
 */
public class Demo02GetOu {
    public static void main(String[] args) {

        System.out.println("main...start...");

        //调用方法getMax: 传递常量
        boolean result = getOu(10);
        System.out.println("是否是偶数? "+result);

        //调用方法getMax: 传递变量
        int num = 11;
        boolean result2 = getOu(num);
        System.out.println(num+"是偶数数字吗? "+result2);

        System.out.println("main...end...");

    }

    //定义一个方法，该方法接收一个int参数，判断该数据是否是偶数，并返回真假值
    /*
        你调用我的方法getOu时,必须给我传递一个int数据,
        我方法内部功能代码执行完毕后,会返还给你一个boolean类型的结果数据
        你: 代表方法的调用者
        我: 方法本身
     */
    public static boolean getOu(int num) {

        boolean result = (num % 2 == 0) ? true : false;

        return result;
    }
}
