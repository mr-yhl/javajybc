package cn.com.mryhl.demo03_field;
/*
继承关系中成员变量访问特点:
    通过子类访问成员，如果子类没有，会向上找父类。
    通过父类访问成员，如果父类没有，不会向下找子类。

同名变量访问：
    直接访问（通过子类对象）
        访问的是之类的变量
    间接访问：
        调用的哪个类的方法,就是访问的哪个类的属性
 */
public class Demo01Test {
    public static void main(String[] args) {
        Zi zi = new Zi();
        Fu fu = new Fu();
        System.out.println(zi.numZi);
        System.out.println(zi.numFu);
        // 同名变量访问
        System.out.println(zi.num);

        zi.showZi();
        zi.showFu();

    }
}
