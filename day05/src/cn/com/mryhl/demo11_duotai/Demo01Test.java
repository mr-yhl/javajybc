package cn.com.mryhl.demo11_duotai;
/*
多态访问成员的特点
多态访问成员变量的特点【了解，不用】
编译看左边父类:如果父类中没有这个变量，编译时期，语法报错
运行也看左边父类:运行时，真正执行的是父类的变量。

多态访问成员方法的特点【重要】
编译看左边父类：如果父类中没有这个方法，编译报错。
运行看右边子类：如果程序运行，运行的是子类的方法。


多态的优缺点：
优点：让程序更加灵活。参数是父类类型，可以传递子类对象。
缺点：只能访问父类中有的东西，不能访问子类特有的内容。【多态方式使用成员，编译会看左边父类】

 */

public class Demo01Test {
    public static void main(String[] args) {
        Fu fu = new Zi();
        // 访问里面的成员变量
        System.out.println(fu.num);
        //  调用方法
        fu.method();
        //fu.methods();
    }
}
