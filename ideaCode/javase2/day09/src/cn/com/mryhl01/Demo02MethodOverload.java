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
方法重载：
1.概念：
在同一个类中，多个功能相同，但是参数列表不同的方法，可以使用相同的名称，
这种多个同名不同参的方法，可以存在于同一个类中的现象，就叫做方法重载
举例：
比如说每个类中有个叫做method的方法，我们可以再载入（书写）,多个名称为method的方法，
但是要求这多个方法之间的参数列表互不相同
2.作用
(1)减少程序员的学习和使用成本
(2)减少了方法名称的数量
3.调用
(1)根据方法名称找到对应的方法
(2)根据参数的数量再次确定方法
(3)最后根据参数的类型确定方法（优先做类型的完全匹配 然后做自动类型提升匹配)
*/

public class Demo02MethodOverload {
    public static void main(String[] args) {
        System.out.println(getSum(5, 6));
        System.out.println(getSum(4, 5, 6));
        System.out.println(getSum(3.4, 5.6));
        System.out.println(getSum(2.3, 4.5, 6.7));

    }

    public static int getSum(int a, int b) {
        System.out.println("2int");
        return a + b;
    }

    public static int getSum(int a, int b, int c) {
        System.out.println("3int");
        return a + b + c;
    }

    public static double getSum(double a, double b) {
        System.out.println("2double");
        return a + b;
    }

    public static double getSum(double a, double b, double c) {
        System.out.println("3double");
        return a + b + c;
    }
}
