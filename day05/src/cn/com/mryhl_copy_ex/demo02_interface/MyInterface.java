package cn.com.mryhl_copy_ex.demo02_interface;
// 接口

/*
 在JDK7以及之前版本
            1. 抽象方法（最核心）
            2. 常量
 在JDK8的时候
            3. 默认方法
            4. 静态方法

 */
public interface MyInterface {
    // 抽象方法
    public abstract void absabstractMethod();
    // 常量
    public static final int CHANGLIANG=10;
    // 默认方法
    public default void defaultMethod(){
        System.out.println("默认方法执行了");
    }
    public static void staticMethod(){
        System.out.println("静态方法执行了");
    }
}
