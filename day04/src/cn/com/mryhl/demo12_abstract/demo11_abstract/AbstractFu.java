package cn.com.mryhl.demo12_abstract.demo11_abstract;

public abstract class AbstractFu {
    // 抽象方法
    public abstract void eat();
    // 普通方法
    public void normaiMethod(){
        System.out.println("普通方法");
    }

    public AbstractFu() {
        System.out.println("父类构造方法");
    }
}
