package cn.com.mryhl.demo06_other;
/*
类与类之间的关系是继承，一个类只能继承一个类。
类与接口之间的关系是实现，一个类可以实现多个接口。
接口与接口之间的关系是继承，一个接口可以继承多个接口
继承：extends
实现：implements
接口多继承的格式：
public interface A extends B, C {
上面代码表示A接口同时继承了B和C这两个接口。
注意:
1.如果多个父接口中有同名的抽象方法，没有影响，抽象方法没有方法体，将来肯定要重写，重写之后的内容是什么执行的内容就是什么
2.如果父接口中有同名的默认方法，有影响的，必须要在子接口中进行重写。

 */
public class Demo01Test {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.abstractMethodA();
        myClass.abstractMethodB();
        myClass.abstractMethod();
    }
}
