package cn.com.mryhl.demo11_abstract;
/*
动物都会吃,所以可以在动物类定义一个eat方法
说不清,道不明吃什么的,使用抽象方法
抽象方法:
    使用abstract修饰,没有方法体
格式:
    public abstract 返回值 方法名(参数列表);
抽象类:
    抽象方法所在的类,必须是抽象类
抽象类的格式
    public abstract class 类名{}

 抽象类的使用:
    1.抽象类不能创建对象
    2.抽象类为了给子类使用,定义一个子类去继承抽象类
    3.在子类中需要重写抽象类中的所有的抽象方法。
    4.创建子类对象，通过子类对象调用方法。

 */
// 动物类
public abstract class Animal {
    public abstract void eat();
}
