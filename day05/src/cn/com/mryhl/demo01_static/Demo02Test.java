package cn.com.mryhl.demo01_static;
/*
static修饰方法
如果一个方法使用static修饰,就不属于对象,属于该类,可以通过类名调用
静态方法和非静态方法使用：
静态方法：可以通过类名，也可以通过对象名调用。建议通过类名调用。
非静态方法：必须有对象才能调用。
如果调用本类中的静态方法，可以省略类名。
静态中的注意事项：
1.静态中不能直接访问非静态的内容。
静态属于类，非静态属于对象，刚开始有类的时候还没有对象呢，所以不能在静态中使用非静态的内容。
2.静态方法中不能使用this 和 super关键字。

*/

public class Demo02Test {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.normalMethod();
        myClass.staticMethod();

        // 通过类型调用
        // MyClass.normalMethod();
        MyClass.staticMethod();
        //调用本类的静态方法
        method();
    }
    public static void method(){
        System.out.println("ddd");
    }
}
