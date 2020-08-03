package cn.com.mryhl.demo07_constructor;
/*
继承关系中构造方法的特点
1.构造方法不能继承
2.创建子类对象时,先执行父类的构造方法,然后执行子类的构造方法.原因是因为在子类的构造方法第一行，有一个隐藏的super(),这个super()是在调用父类的构造方法
3.我们也可使super手动调用父类的构造方法
    super(参数);
4.如果使用super调用构造方法,一定要放在第一行
 */

public class Demo01Test {
    public static void main(String[] args) {
        Zi zi = new Zi();

    }
}
