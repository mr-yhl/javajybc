package cn.com.mryhl03;
/*无返回值有参数方法的定义和调用
        1.无返回值
        方法的功能代码执行完毕后，没有具体的结果数据返还给方法的调用者/处，
        此时方法内部只能写return;而且返回值类型必须固定写为void
        2.有参数
       经验分析：如果题目需求中有不确定的东西，就需要定义参数列表
        3.注意：
        (1)方法定义完毕后，不调用是不会执行的
        (2)调用格式：
        方法名称（参数列表...)
        (3)方法定义完毕后，可以调用任意多次
        4.练习：
        定义一个方法，打印该方法内部的两个数据（方法内部定义的变量）的最大值
        */
public class Demo01PrintMax {
    public static void main(String[] args) {
        System.out.println("main..............start....");
        printMax(20,60);
        System.out.println("main..............end....");
    }
    /*你调用我的方法printou时，必须给我传递两个int数据，
    就方法内部功能代码执行完毕后，没有结果数据返回给你，内部会直接打印结果数据*/
    public static void printMax(int a,int b){

        int max = a>b?a:b;
        System.out.println("最大值是:"+max);
        return;
    }
}
