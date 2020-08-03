package cn.com.mryhl.demo04_interface_static;
/*
在JDK8的时候，接口中也可以有静态方法啦。
静态方法的格式：
    public static返回值类型方法名（参数列表）{
        方法体；
        return返回值；
    }
注意：
    1.静态方法中的public可以省略。
    2.如果省略pubLic,那么这个方法也是用public修饰的。
接口中静态方法的使用：
    1.接口中的静态方法可以通过接口名直接调用。
    2.不能通过实现类调用


 */
public interface MyInterface {
public static void staticMethod(){
    System.out.println("接口中的静态方法");
}

}
