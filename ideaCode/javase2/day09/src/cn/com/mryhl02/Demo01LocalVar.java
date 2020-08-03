package cn.com.mryhl02;
/*
1.基本类型变量a的值，赋值给基本类型变量b,其实是把变量a的值复制一份给变量b,
之后不管如何修改变量b中的值，对变量a中的值是不会产生任何影响的
2.方法内部或者方法定义时（)中定义的变量，称之为局部变量，只在方法内部有效，出了所在的方法就不能使用到了
*/
public class Demo01LocalVar {
    public static void main(String[] args) {
        int a = 10;
        int b;//定义未赋值
        b = a;
        System.out.println("a="+a);
        System.out.println("b="+b);
        b*=10;
        System.out.println("a="+a);
        System.out.println("b="+b);
    }
    public static void method(){
        /*a和b是在main方法中定义的，只能在main方法中使用
        System.out.println("a="+a);
        System.out.println("b="+b);
        */
    }
}
