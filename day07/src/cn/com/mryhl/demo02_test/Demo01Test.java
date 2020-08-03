package cn.com.mryhl.demo02_test;
/*
要求：
定义一个方法，该方法接收一个Person类型作为参数，然后在方法中让Person去吃。
定义一个方法，该方法使用Person类型作为返回值类型，在方法中返回一个对象。

根据多态性,子类类型可以当成父类类型看待
如果方法参数是一个类，那么我们也可以传递他的子类对象。


 */
public class Demo01Test {
    public static void main(String[] args) {
        //showEat(new Student());

        Person p = createPerson();
        p.eat();
        showEat(p);
    }
    /*

    定义一个方法，该方法接收一个Person类型作为参数，然后在方法中让Person去吃。
        参数：Person
        返回值类型：void
   */
    public static void showEat(Person p){
        p.eat();
    }
    /*
    定义一个方法，该方法使用Person类型作为返回值类型，在方法中返回一个对象
     参数:没有
     返回值:Person
     */
    public static Person createPerson(){
        Person p = new Teacher();
        return p;
    }
}
