package cn.com.mryhl.demo07_other.demo06_other;

/*
一个类在继承父类的同时实现多个接口。
格式：
public class A extends B implements I1, I2 {
上面代码表示A类继承日类的同时，实现了11和工2这两个接口，

注意:
    如果父类中的方法与接口中的默认方法同名是可以的,执行的是父类的方法
 */
public class Demo01Test {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.abstractMethodA();
        myClass.abstractMethodB();
        myClass.superMethod();
        myClass.abstractMethod();
    }
}
