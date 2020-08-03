package cn.com.mryhl05;

/*
形式参数和实际参数的区别
注意:
实参与形参名字可以相同也可以不同
*/
public class Demo04MethodParam {
    public static void main(String[] args) {
        System.out.println("main...start...");
        //调用方法,传递参数
        /*
        实际参数
        1.概念：在调用方法时，()中指定的常量/变量，称为实际参数
        2.特点
            (1)是在调用方法时，()中指定的常量/变量
            (2)必须是有具体的数据值的
        */
        int m = 10, n = 0;
        int result = getNum(m, n);
        System.out.println(result);

        System.out.println("main...end...");
    }

    //定义方法，获取两个int数据之和
   /* 形式参数
        1.概念：在定义方法时，()中定义的参数（变量）,叫做形式参数
        2.特点：
            (1)是在定义方法时，()中指定的
            (2)此时是没有值的，调用方法时，由方法的调用者传递具体的数据给对应的形式参数


        */
    public static int getNum(int a, int b) {//此处（)中的a和，叫做形式参数
        int sum = a + b;

        return sum;
    }
}
