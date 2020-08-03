package cn.com.mryhl.demo06_other;
//实现MyInterfaceChild接口
public class MyClass implements MyInterfaceChild {
    @Override
    public void abstractMethod() {
        System.out.println("共有的方法");
    }

    @Override
    public void abstractMethodA() {
        System.out.println("重写了A");
    }

    @Override
    public void abstractMethodB() {
        System.out.println("重写lB");
    }
}
