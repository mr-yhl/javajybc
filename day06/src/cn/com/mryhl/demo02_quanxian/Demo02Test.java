package cn.com.mryhl.demo02_quanxian;

public class Demo02Test {
    public static void main(String[] args) {
        //创建MyClass对象
        MyClass m = new MyClass();
        //调用方法
        m.publicMethod();
        m.protectedMethod();
        m.defaultMethod();
        //m.privateMethod();
    }
}
