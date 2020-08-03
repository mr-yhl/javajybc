package cn.com.mryhl01;
/*
1.定义一个获取两个int数字之和的方法
2.定义一个获取三个int数字之和的方法
3.定义一个获取两个double数字之和的方法
4.定义一个获取三个double数字之和的方法
定义一个获取两个int数字之和的方法
三要素：
1.方法名称：getTwoIntNumSum
2.参数列表：int a,int b
3.返回值类型：int

发现问题：
以下四个方法都是完成求和功能，只是参数列表不同，然而我们却给每个方法都起了一个很长的而且非常复杂的名字，
导致程序员的学习和使用成本增加（太复杂，记不住）

*/
public class Demo01Method {
    public static void main(String[] args) {
        System.out.println(getTwoIntNum(5,6));
        System.out.println(getThreeIntNum(4,5,6));
        System.out.println(getTwoDoubleNum(3.4,5.6));
        System.out.println(getThreeDoubleNum(2.3,4.5,6.7));

    }

    public static int getTwoIntNum(int a,int b) {
        return a+b;
    }
    public static int getThreeIntNum(int a,int b,int c) {
        return a+b+c;
    }
    public static double getTwoDoubleNum(double a,double b) {
        return a+b;
    }
    public static double getThreeDoubleNum(double a,double b,double c) {
        return a+b+c;
    }
}
