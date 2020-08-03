package cn.com.mryhl.demo01_quanxian;


import cn.com.mryhl.demo02_quanxian.MyClass;

/*
    Java中的权限修饰符。

    Java中有四种权限，分别是public protected 默认 private


    public：公共的。被public修饰的成员可以在任何位置使用。
    protected：受保护的。 被protected修饰的成员只能在本包中，以及其他包下的子类中使用。不能在其他包下的无关类中使用。
    默认：如果权限修饰符留空不写，那么就是默认权限。默认权限的成员只能在本包中使用。
    private：私有。 被private修饰的成员只能在本类中使用。

    四种权限修饰符从大到小： public > protected > 默认 > private
    重点掌握：public private

 */
public class Demo01Test {
    public static void main(String[] args) {
        //创建MyClass对象
        MyClass m = new MyClass();
        //调用方法
        m.publicMethod();
        //m.protectedMethod();
        //m.defaultMethod();
    }
}
