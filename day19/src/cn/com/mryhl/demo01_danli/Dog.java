package cn.com.mryhl.demo01_danli;
/*
单例模式要求某个类的对象只能创建一个。
单例模式有两种，分别是懒汉式【后创建对象】和饿汉式【先创建对象】
下面的单例模式是懒汉式,是在调用getDog方法之后创建的对象。
 */


public class Dog {
    /*
    * 定义一个Dog类型的变量,用来接收getDog方法中创建的Dog对象
    * */
    private static Dog dog = null;
    /**
     * 私有构造方法,让外界不能创建对象
     * */
    private Dog(){}
    /**
     * 定义静态方法,获取dog对象
     *
     */
    public static synchronized Dog getDog(){
        // 调用getDog对象获取对象时,判断dog变量是否是null,如果是null,表示之前没有获取过Dog对象，那么就创建一个Dog对象赋值给dog
        if (dog == null) {

            dog = new Dog();
        }
        return dog;
    }
}
