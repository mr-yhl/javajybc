package cn.com.mryhl.demo12_parse;
/*
向上转型：子类可以转换成父类类型
格式：
    父类类型 变量名 = new 子类类型（）；
向下转型::父类类型转成子类类型
格式:
    子类类型 变量名 = (子类类型)父类变量;
 向下转型前必须要有向上转型

父类类型表示的对象不是目标类型，再转换的时候会报错。（如果父类类型表示的是猫，但是我们却把它向下转型成狗,就会报错)
多态的弊端就是不能调用子类特有的方法.想要调用子类特有的内容,需要进行向下转型
*/

public class Demo01Test {
    public static void main(String[] args) {
        // 多态  向上转型
        Animal a = new Dog();
        System.out.println(a);
        //Animal a = new Cat();
        /*Exception in thread "main" java.lang.ClassCastException: cn.com.mryhl.demo12_parse.Cat cannot be cast to cn.com.mryhl.demo12_parse.Dog
        at cn.com.mryhl.demo12_parse.Demo01Test.main(Demo01Test.java:24)*/
        // 调用方法
        a.eat();

        // a.lookDoor();//子类特有不能调用
        // 把Animal类型的a转成Dog
        Dog d = (Dog) a;
        System.out.println(d);
        d.eat();
        // 调用 看门方法
        d.lookDoor();
    }
}
