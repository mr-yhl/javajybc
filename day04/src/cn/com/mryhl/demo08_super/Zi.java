package cn.com.mryhl.demo08_super;

public class Zi extends Fu{

    public Zi() {
        super("hello");
    }

    int num = 20;
    public void show(){
        super.method();
    }
    public void method(){
        System.out.println("子类的method方法执行");
    }
}
