package cn.com.mryhl.demo04_override;
/*
继承关系中成员方法访问特点
    如果子类的成员方法和父类的成员方法同名，那么通过子类对象访问的是子类的成员方法。
在子类中出现了和父类一样的方法,叫做重写Override
    重载(Overload):方法名相同,参数列表不同
    重写(Override):子类和父类方法一样

 */
public class Demo01Test {
    public static void main(String[] args) {
        Zi zi = new Zi();

        zi.methodZu();
        zi.methodFu();

        zi.method();
    }
}
