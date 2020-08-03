package cn.com.mryhl.demo07_other.demo06_other;

//实现MyInterfaceChild接口
public class MyClass extends MySuperClass implements MyInterfA,MyInterfB {

    @Override
    public void abstractMethodA() {
        System.out.println("MyClass重写的MyInterfacea");

    }

    @Override
    public void abstractMethod() {
        System.out.println("这他妈是重名的那个");
    }

    /*@Override
    public void defaultMethod() {
        System.out.println("这他妈是重名的默认方法");
    }*/

    @Override
    public void abstractMethodB() {
        System.out.println("MyClass重写的MyInterfaceb");
    }
}
