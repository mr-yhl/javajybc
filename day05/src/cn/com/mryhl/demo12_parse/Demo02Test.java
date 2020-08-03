package cn.com.mryhl.demo12_parse;
/*
instanceof关键字
作用:判断变量是否是该类型的对象.
格式:
 变量名  instanceof  数据类型
 举例:
 a instanceof Dog
 判断a是不是Dog类型对象
使用场景：
向下转型之前，我们可以使用instanceof关键字进行判断。如果类型符合，再进行向下转换。


*/
public class Demo02Test {
    public static void main(String[] args) {
        //Animal a = new Dog();
        Animal a = new Cat();

        a.eat();
        //判断判断a是不是Dog类型对象
        if (a instanceof Dog) {
            Dog d = (Dog) a;
            d.lookDoor();
        }
        // 如果a是cat对象
        if (a instanceof Cat){
            Cat c = (Cat) a;
            c.catchMouse();
        }

        //转型
    }
}
