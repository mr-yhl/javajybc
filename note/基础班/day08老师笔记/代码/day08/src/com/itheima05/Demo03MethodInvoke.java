package com.itheima05;
/*
    有返回值的方法调用方式
        1.赋值调用: 把调用有返回值的方法的返回结果保存到变量中                       推荐使用
            数据类型 变量名称 = 方法名称(参数列表...);

        2.打印/输出调用: 把调用有返回值的方法的返回结果直接交给输出语句,进行打印输出
            System.out.println(方法名称(参数列表...));

        3.直接/单独/独立调用        代码是没有错误的,但是丢失了结果数据, 没有意义     不推荐使用
            方法名称(参数列表...);
 */
public class Demo03MethodInvoke {
    public static void main(String[] args) {
        System.out.println("main...start...");

        //调用方法,传递常量
        //1.赋值调用: 把调用有返回值的方法的返回结果保存到变量中
        int result = getSum(10, 20);

        //把结果保存到变量中的好处: 可以对结果数据进行额外的其它处理
        //result *= 1000;//此处只是举一个例子
        System.out.println("和: "+result);

        //2.打印/输出调用: 把调用有返回值的方法的返回结果直接交给输出语句,进行打印输出
        System.out.println("和: "+getSum(10,20));

        //3.直接/单独/独立调用        代码是没有错误的,但是丢失了结果数据, 没有意义     不推荐使用
        getSum(10,20);

        System.out.println("main...end...");
    }

    //定义方法,获取两个int数据之和
    public static int getSum(int a, int b) {

        int sum = a + b;

        return sum;
    }
}
