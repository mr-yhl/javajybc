package cn.com.mryhl.demo02_interface_abstract;

/*
接口最核心的就是抽象方法
任何版本的java中,接口中都可以有抽象方法

抽象方法的定义格式：
public abstract返回值类型方法名（参数列表）;
注意：
    1.接口中的抽象方法可以省略public abstract关键字
    2.如果省略public abstract,那么抽象方法也是使用public abstract修饰


接口中抽象方法的使用:
    1. 接口不能创建对象
    2. 我们要定义一个类,让这类实现这个接口
    3.在类中重写接口中所有抽象方法
    4.创建对象,通过类的对象调用方法

类实现接口的格式:
    public class A implements I{

    }
    表示A类实现了I接口,A也叫I接口的实现类

注意:一个普通类实现接口,需重写所有抽象方法
    一个抽象类实现接口,可以不重写抽象方法
 */
public interface MyInterface {

    // 定义抽象方法
    public abstract void method();

    abstract void method2();

    public void method3();

    void method4();
}
