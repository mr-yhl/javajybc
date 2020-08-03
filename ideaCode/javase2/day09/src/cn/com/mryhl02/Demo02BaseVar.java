package cn.com.mryhl02;



/*
基本类型作为方法参数传递的特点
1.基本类型变量保存的具体的数据值，进行赋值时，传递的也是具体的数据值
2.基本类型作为方法参数时，形式参数的改变，不会影响实际参数

注意：
1.方法的执行都有自己独立的栈内存空间
2.方法内部定义的变量也有独立的内存空间
3.不同的方法中可以定义同名的变量，因为所在的方法的楼内存空间不同，同名变量的内存空间也不同，
他们之间是互不干扰，互不影响
*/
public class Demo02BaseVar {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("a="+a);//10
        System.out.println("b="+b);//20
        change(a,b);
        System.out.println("ea="+a);//10
        System.out.println("eb="+b);//20
    }
    public static void change(int a,int b){
        System.out.println("ch.a="+a);//10
        System.out.println("ch.b="+b);
        a*=10;
        b*=10;
        System.out.println("ech.a="+a);//10
        System.out.println("ech.b="+b);
    }
}
