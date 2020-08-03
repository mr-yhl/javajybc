package com.itheima05;
/*
    方法的注意事项二
        1.返回值类型，必须要和 return 语句返回的数据的类型要匹配，否则编译失败 。
        2.不能在 return 后面写代码， return 意味着方法结束，所有后面的代码永远不会执行，属于无效代码。
        3.void表示无返回值，可以省略return ;，也可以单独的书写return ;，后面不加数据 return ; 建议省略
        4.如果定义的方法需要返回值,那么只能返回一个数据,不能返回2个及以上的数据
            而且可以返回基本类型也可以返回引用类型(根据需求确定)
            如果非得返回多个数据,可以把多个数据放在数组中,返回一个数组
 */
public class Demo02MethodNotice {
    public static void main(String[] args) {

    }

    //1.返回值类型，必须要和 return 语句返回的数据的类型要匹配，否则编译失败 。
    public static boolean a() {
        //return 100;//返回值类型: int
        //return 6.6;//返回值类型: double
        //return 6.6F;//返回值类型: float
        return true;//返回值类型: boolean
    }

    //2.不能在 return 后面写代码， return 意味着方法结束，所有后面的代码永远不会执行，属于无效代码。
    public static int getMax(int a,int b) {
        if(a>b) {
            return a;
            //System.out.println("a...");
        } else {
            return b;
            //System.out.println("b....");
        }
        //System.out.println("getMax....end...");
    }
}
