package cn.com.mryhl.demo10_duotai_good;
/*
多态的好处：
多态的参数如果是父类类型，那么可以传递任何子类对象。程序会更加灵活
        原因：
        根据多态性，子类类型可以当成父类类型去看待。比如狗肯定是动物，所以可以当成动物去看待。
        参数需要的是动物（父类）类型，那么我们可以传递狗（子类）对象。因为狗肯定是动物。*/

public class Demo01Test {
    public static void main(String[] args) {
        // 调用showSay()方法
        showSay(new Cat());// 匿名对象
        showSay(new Dog());// 匿名对象
    }
    /*
    定义方法,该方法让猫叫
     */
    /*public static void showSay(Dog dog){
        dog.say();
    }*/
    /*
    定义方法,该方法让猫叫
     */
    /*public static void showSay(Cat cat){
        cat.say();
    }*/
  /*  定义方法,让任何动物叫*/
    public static void showSay(Animal animal){
        animal.say();
    }
}
